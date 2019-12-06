package executor;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Help<T> {
    T help(ResultSet set) throws SQLException;
}
