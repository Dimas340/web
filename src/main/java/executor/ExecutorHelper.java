package executor;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExecutorHelper<T> {
    T help(ResultSet set) throws SQLException;
}
