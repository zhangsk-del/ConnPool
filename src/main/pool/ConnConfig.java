package pool;

public class ConnConfig {
    private static String forName = (String) ReadProperties.getValues("forName");
    private static String url = (String) ReadProperties.getValues("url");
    private static String userName = (String) ReadProperties.getValues("userName");
    private static String password = (String) ReadProperties.getValues("password");
    private static String maxConn = (String) ReadProperties.getValues("maxConn");
    private static String maxLeisure = (String) ReadProperties.getValues("maxLeisure");


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

    public String getMaxConn() {
        return maxConn;
    }

    public String getMaxLeisure() {
        return maxLeisure;
    }
}
