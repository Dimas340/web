package executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private final Connection connection;


    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void executeUpdate(String command) {
        try {
            connection.setAutoCommit(false);

            Statement stmt = connection.createStatement();
            stmt.execute(command);
            stmt.close();

            connection.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public <T> T executeQuery(String query, ExecutorHelper<T> helper) {
        T user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            user = helper.help(resultSet);
            connection.setAutoCommit(false);
            resultSet.close();

            statement.close();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
        return user;
    }
}
