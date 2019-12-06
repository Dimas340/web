package servise;

import dao.Dao;
import dao.DaoImpl;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {
    private Dao dao;

    public ServiceImpl() {
        dao = new DaoImpl(getMysqlConnection());
    }

    private Connection getMysqlConnection() {
        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/crud?useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void addingUser(User user) {
        dao.addingUser(user);
    }

    @Override
    public User returnById(long id) {
        return dao.returnById(id);
    }

    @Override
    public void editUser(User user) {
        dao.editUser(user);
    }

    @Override
    public void deleteUser(long id) {
        dao.deleteUser(id);
    }
}
