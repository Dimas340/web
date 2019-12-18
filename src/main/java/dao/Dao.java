package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface Dao {

    List<User> getAllUsers();

    void addingUser(User user);

    User returnById(long id);

    void editUser(User user);

    void deleteUser(User user);

    User returnByLogin(String login);
}
