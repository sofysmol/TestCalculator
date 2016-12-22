package sofysmo.testcalculator.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sofysmo.testcalculator.dao.TestCaseDao;
import sofysmo.testcalculator.dao.TestPlanDao;
import sofysmo.testcalculator.dao.mysql.MySqlDaoFactory;
import sofysmo.testcalculator.dao.mysql.MySqlTestCaseDao;
import sofysmo.testcalculator.dao.mysql.MySqlTestPlanDao;

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
    public DriverManagerDataSource dataSource(){
        return (new MySqlDaoFactory()).getDataSource(env);
    }
    @Bean
    public TestCaseDao testCaseDao() throws SQLException{
        return new MySqlTestCaseDao(dataSource());
    };

    @Bean
    public TestPlanDao testPlanDao() throws SQLException{
        return new MySqlTestPlanDao(dataSource());
    };
    

}
