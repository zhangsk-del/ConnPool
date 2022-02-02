package pool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 静态代理代理类，便于统一管理和修改
 *
 *
 */
public class MyConnection extends AbstConnection {

    // 这里读取配置文件信息
    private Connection conn;
    private static ConnConfig cfg = new ConnConfig();
    // false 表示连接未使用、true连接正在使用
    private boolean isTem = false;

    // 加载驱动，并执行一次
    static {
        try {
            Class.forName(cfg.getForName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取链接对象
    {
        try {
            conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUserName(), cfg.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Statement createStatement() throws SQLException {
        return conn.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    @Override
    public void close() throws SQLException {
        this.setTem(false);
    }

    public boolean isTem() {
        return isTem;
    }

    public void setTem(boolean tem) {
        isTem = tem;
    }
}
