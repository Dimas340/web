package servise;

import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Service {
    List<User> getAllUsers();

    void addingUser(User user);

    User returnById(long id);

    void editUser(User user);

    void deleteUser(User user);
}
