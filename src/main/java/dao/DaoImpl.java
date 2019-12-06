package dao;


import executor.Executor;
import model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {
    private Executor executorImpl;

    public DaoImpl(Connection connection) {
        this.executorImpl = new Executor(connection);
    }


    @Override
    public List<User> getAllUsers() {
        return executorImpl.executeQuery("select * from crud", resultSet -> {
            List<User> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            return list;
        });
    }

    @Override
    public void addingUser(User user) {
        executorImpl.executeUpdate("insert into crud (login, password) values ('" + user.getLogin() + "', '"
                + user.getPassword() + "')");
    }

    @Override
    public User returnById(long id) {
        return executorImpl.executeQuery("SELECT * FROM crud WHERE id='" + id + "'", result -> {
            result.next();
            return new User(
                    result.getLong(1),
                    result.getString(2),
                    result.getString(3)
            );
        });
    }

    @Override
    public void editUser(User user) {
        executorImpl.executeUpdate("UPDATE crud SET login='" + user.getLogin() + "', password='" + user.getPassword()
                + "' WHERE id='" + user.getId() + "'");
    }

    @Override
    public void deleteUser(long id) {
        executorImpl.executeUpdate("DELETE FROM crud WHERE id='" + id + "'");
    }

}

