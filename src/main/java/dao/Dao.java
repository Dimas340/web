package dao;

import model.User;

import java.util.List;

public interface Dao {

    List<User> getAllUsers();

    void addingUser(User user);

    User returnById(long id);

    void editUser(User user);

    void deleteUser(long id);
}
