import org.junit.Test;
import pool.ReadProperties;

/**
 * 这里是简单的测试
 */
public class TestReadProperties {


    @Test
    public void readFile() {
        String url = (String) ReadProperties.getValues("url");
        String forName = (String) ReadProperties.getValues("forName");
        String userName = (String) ReadProperties.getValues("userName");
        String password = (String) ReadProperties.getValues("password");
        String maxConn = (String) ReadProperties.getValues("maxConn");
        System.out.println(url);
        System.out.println(forName);
        System.out.println(userName);
        System.out.println(password);
        System.out.println(maxConn);
    }

}




