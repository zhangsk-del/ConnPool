package pool;

public class ConnConfig {
    private static String forName = (String) ReadProperties.getValues("forName");
    private static String url = (String) ReadProperties.getValues("url");
    private static String userName = (String) ReadProperties.getValues("userName");
    private static String password = (String) ReadProperties.getValues("password");
    private static Integer maxConn = (Integer) ReadProperties.getValues("maxConn");
    private static Integer maxLeisure = (Integer) ReadProperties.getValues("maxLeisure");


    public String getForName() {
        return forName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getMaxConn() {
        return maxConn;
    }

    public Integer getMaxLeisure() {
        return maxLeisure;
    }
}
