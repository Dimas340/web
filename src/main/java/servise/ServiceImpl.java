package servise;

import dao.ReadFromFile;
import dao.Dao;
import model.User;

import java.util.List;

public class ServiceImpl implements Service {
//    private Dao dao = new DaoJdbcImpl();
//    private Dao dao = DaoHibernateImpl.getInstance();
    private final Dao dao;

    public ServiceImpl() {
        dao = new ReadFromFile().getDao();

    }
    @Override
    public List<User> getAllUsers(){
        return dao.getAllUsers();
    }

    @Override
    public void addingUser(User user){
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
