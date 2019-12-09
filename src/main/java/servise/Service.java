package servise;

import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Service {
    List<User> getAllUsers() throws SQLException;

    void addingUser(User user) throws SQLException;

    User returnById(long id);

    void editUser(User user);

    void deleteUser(long id);
}
