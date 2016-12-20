package sofysmo.testCalculator.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sofysmo.testCalculator.dao.TestCaseDao;
import sofysmo.testCalculator.dao.TestPlanDao;
import sofysmo.testCalculator.dao.mysql.MySqlDaoFactory;
import sofysmo.testCalculator.dao.mysql.MySqlTestCaseDao;
import sofysmo.testCalculator.dao.mysql.MySqlTestPlanDao;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sofysmo on 08.10.16.
 */
@Configuration
public class AppConfig {
    @Resource
    public Environment env;

    @Bean
    public Connection connection() throws SQLException {
        return (new MySqlDaoFactory()).getConnection(env);
    }

    @Bean
    public TestCaseDao testCaseDao() throws SQLException{
        return new MySqlTestCaseDao(connection());
    };

    @Bean
    public TestPlanDao testPlanDao() throws SQLException{
        return new MySqlTestPlanDao(connection());
    };
    

}
