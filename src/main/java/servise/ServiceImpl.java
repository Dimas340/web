package servise;

import dao.Factory;
import dao.Dao;
import dao.SpecificFactory;
import model.User;

import java.util.List;

public class ServiceImpl implements Service {
    private static Dao dao;
    private static ServiceImpl instance;

    private ServiceImpl() {
        Factory factory = new Factory();
        factory.choice();
        dao = new SpecificFactory().getDao();
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
}
