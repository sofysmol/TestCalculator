package sofysmo.testcalculator.dao.mysql;

import org.springframework.core.env.Environment;
import sofysmo.testcalculator.dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlDaoFactory implements DaoFactory {

    public Connection getConnection(Environment env) throws SQLException {
        return DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password"));
    }
}
