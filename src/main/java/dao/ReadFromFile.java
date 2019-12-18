package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromFile {
    private Dao dao;

    public ReadFromFile() {
        String result = null;
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("propertyConnection.properties")) {
            properties.load(input);
            result = properties.getProperty("nameConnection");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.equals("jdbc")) {
            dao = DaoJdbcImpl.getInstance();
        } else if (result.equals("hibernate")) {
            dao = DaoHibernateImpl.getInstance();
        }
    }

    public Dao getDao() {
        return dao;
    }
}
