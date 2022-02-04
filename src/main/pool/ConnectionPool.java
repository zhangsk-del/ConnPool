package pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 管理好多连接
 */

public class ConnectionPool {

    // 获取连接的等待时间 50*100 ms
    private final int waitTime = 50;

    private ReentrantLock lock = new ReentrantLock();

    // 这里存储连接对象
    private static ArrayList<Connection> connList = new ArrayList();

    private static ConnConfig cfg = new ConnConfig();

    static {
        for (int i = 0; i < cfg.getMaxConn(); i++) {
            connList.add(new MyConnection());
        }
    }

    // 1.私有的构造方法
    private ConnectionPool() {
    }

    // 2.存在一个当前类私有的静态的对象
    private static ConnectionPool pool;

    // 3.提供一个获取唯一对象的方法
    public static ConnectionPool getPool() {
        if (pool == null) {
            synchronized (ConnectionPool.class) {
                if (pool == null) {
                    pool = new ConnectionPool();
                }
            }
        }
        return pool;

    }

    /**
     * 获取一个连接
     *
     * @return 连接对象
     */
    private Connection getConn() {
        Connection connection = null;
        for (int i = 0; i < connList.size(); i++) {
            MyConnection conn = (MyConnection) connList.get(i);
            // 尝试获取锁，获取不到则不等待
            try {
                // 锁定当前线程池的对象
                lock.lock();
                if (conn.isTem() == false) {
                    // 将链接占为即有
                    conn.setTem(true);
                    connection = conn;
                    break;
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
        return connection;
    }

    // 提供对外的方法
    public Connection getConnection() {
        Connection conn = getConn();
        int size = 0;
        while (conn == null && size < waitTime) {
            conn = getConn();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            size++;
        }
        if (conn == null) {
            throw new RuntimeException("no connection is currently available");
        }
        return conn;
    }
}
