package dao;

import config.DbConn;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DaoHibernateImpl implements Dao {
    private SessionFactory sessionFactory;
    private static DaoHibernateImpl instance;

    public DaoHibernateImpl() {
        sessionFactory = DbConn.getMySqlConfiguration();// сделать так чтобы config создавался один раз
    }

    public static DaoHibernateImpl getInstance() {
        if (instance == null) {
            instance = new DaoHibernateImpl();
        }
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = null;
        try {
            String hql = "FROM User";
            Query query = session.createQuery(hql);
            list = (List) query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public void addingUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public User returnById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = null;
        try {
            user = (User) session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public User returnByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = null;
        try {
            String hql = ("FROM User where login='" + login + "'");
            Query query = session.createQuery(hql);
            user = (User) query.uniqueResult();
            System.out.println(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }
}
