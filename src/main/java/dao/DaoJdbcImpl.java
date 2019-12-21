package dao;

import config.DbConn;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoJdbcImpl implements Dao {
    private Connection connection;

    public DaoJdbcImpl() {
        DbConn.getInstance();
        connection = DbConn.getConnection();
    }

//    @Override
//    public List<User> getAllUsers() {
//        return executorImpl.executeQuery("select * from crud", resultSet -> {
//            List<User> list = new ArrayList<>();
//            while (resultSet.next()) {
//                list.add(new User(
//                        resultSet.getLong(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3)
//                ));
//            }
//            return list;
//        });
//    }

//    @Override
//    public void addingUser(User user) {
//        executorImpl.executeUpdate("insert into crud (login, password) values ('" + user.getLogin() + "', '"
//                + user.getPassword() + "')");
//    }

//    @Override
//    public User returnById(long id) {
//        return executorImpl.executeQuery("SELECT * FROM crud WHERE id='" + id + "'", result -> {
//            result.next();
//            return new User(
//                    result.getLong(1),
//                    result.getString(2),
//                    result.getString(3)
//            );
//        });
//    }

//    @Override
//    public void editUser(User user) {
//        executorImpl.executeUpdate("UPDATE crud SET login='" + user.getLogin() + "', password='" + user.getPassword()
//                + "' WHERE id='" + user.getId() + "'");
//    }

    //    @Override
//    public void deleteUser(long id) {
//        executorImpl.executeUpdate("DELETE FROM crud WHERE id='" + id + "'");
//    }
    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        String command = "select * from crud";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(command);
            list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addingUser(User user) {
        String command = "insert into crud (login, password, role) VALUES ('" + user.getLogin() +
                "', '" + user.getPassword() + "', '"+ user.getRole() + "')";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User returnById(long id) {
        String command = "SELECT * FROM crud WHERE id='" + id + "'";
        User user = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                return new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void editUser(User user) {
        String command = "update crud SET login='" + user.getLogin() + "', password='" + user.getPassword()
                + "', role='" + user.getRole() + "' where id='" + user.getId() + "'";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        String command = "DELETE FROM crud WHERE id='" + user.getId() + "'";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

