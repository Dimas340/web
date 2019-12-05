package dao;


import executor.Executor;
import model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao{
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

}

