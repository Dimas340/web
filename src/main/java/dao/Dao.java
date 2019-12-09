package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface Dao {

    List<User> getAllUsers() throws SQLException;

    void addingUser(User user) throws SQLException;

    User returnById(long id);

    void editUser(User user);

    void deleteUser(long id);
}
