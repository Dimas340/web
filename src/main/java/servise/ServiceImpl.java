package servise;

import dao.Dao;
import dao.fabrics.Factory;
import model.User;

import java.util.List;

public class ServiceImpl implements Service {
    private static Dao dao;
    private static ServiceImpl instance;

    private ServiceImpl() {
        Factory factory = Factory.choice();
        dao = factory.createDao();

    }

    public static ServiceImpl getInstance() {
        if (instance == null) {
            synchronized (ServiceImpl.class) {
                if (instance == null) {
                    instance = new ServiceImpl();
                }
            }
        }
        return instance;
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
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public User getUserLogin(String login) {
        return dao.getUserLogin(login);
    }
}
