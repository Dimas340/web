package servise;

import dao.Dao;
import dao.DaoHibernateImpl;
import dao.DaoJdbcImpl;
import model.User;

import java.util.List;

public class ServiceImpl implements Service {
//    private Dao dao = new DaoJdbcImpl();
    private Dao dao = DaoHibernateImpl.getInstance();

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
