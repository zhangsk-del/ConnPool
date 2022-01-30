package pool;

import java.sql.Connection;
import java.util.ArrayList;


/*
    管理好多连接
 */
public class ConnectionPool {

    // 这里存储连接对象
    private static ArrayList<Connection> conn = new ArrayList();

    private static ConnConfig cfg = new ConnConfig();

    static {
        for (int i = 0; i < cfg.getMaxConn(); i++) {
            conn.add(new MyConnection());
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

    // 提供对外的方法
    public Connection getConnection() {

        return null;
    }

}
