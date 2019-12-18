package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Factory {

    public Factory() {
    }

    public void choice() {
        String conn = "nameConnection";

        String result = null;
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("propertyConnection.properties")) {
            properties.load(input);
            result = properties.getProperty(conn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpecificFactory specificFactory = new SpecificFactory();
        specificFactory.createConnection(result);
    }
}

