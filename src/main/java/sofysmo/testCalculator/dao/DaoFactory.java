package sofysmo.testCalculator.dao;

import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sofysmo on 19.12.16.
 */
public interface DaoFactory {
    public Connection getConnection(Environment env) throws SQLException;
}
