package sofysmo.testCalculator.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sofysmo.testCalculator.dao.DaoFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlDaoFactory implements DaoFactory {

    @Autowired
    Environment env;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password"));
    }
}
