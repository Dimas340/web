package dao;

import model.User;

import java.util.List;

public interface Dao {

    List<User> getAllUsers();
    void addingUser(User user);
}
