package sofysmo.testCalculator.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sofysmo.testCalculator.dao.mysql.MySqlDaoFactory;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sofysmo on 08.10.16.
 */
@Configuration
public class AppConfig {
    @Resource
    private Environment env;

    @Bean
    public Connection connection() throws SQLException {
        return (new MySqlDaoFactory()).getConnection();
    }
}
