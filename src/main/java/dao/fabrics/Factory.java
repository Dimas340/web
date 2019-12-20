package dao.fabrics;

import dao.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class Factory {
    private static Factory factory;

    public static Factory choice() {
        String conn = "nameConnection";

        String result = null;
        Properties properties = new Properties();
        try (InputStream input = Factory.class.getClassLoader().getResourceAsStream("propertyConnection.properties")) {
            properties.load(input);
            result = properties.getProperty(conn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result != null) {
            switch (result) {
                case "jdbc":
                    factory = new FactoryJdbc();
                    break;

                case "hibernate":
                    factory = new FactoryHibernate();
                    break;
            }
        }
        return factory;
    }

    public abstract Dao createDao();

}
