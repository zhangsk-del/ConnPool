package pool;


import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    // 这里读取配置文件信息

    private ConnConfig conn;
    private static ConnConfig cfg = new ConnConfig();

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
            conn = (ConnConfig) DriverManager.getConnection(cfg.getUrl(), cfg.getUserName(), cfg.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
