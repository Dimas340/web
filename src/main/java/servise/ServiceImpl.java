package servise;

import dao.Dao;
import dao.DaoImpl;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {
    private Dao dao = new DaoImpl();

    @Override
    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    @Override
    public void addingUser(User user) throws SQLException {
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
