package sofysmo.testcalculator.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sofysmo.testcalculator.dao.TestPlanDao;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.database.TestPlanDB;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlTestPlanDao extends AbstractJDBCDao<TestPlanDB> implements TestPlanDao {

    public MySqlTestPlanDao(DataSource dataSource){
        super(dataSource);
    }

    protected RowMapper<TestPlanDB> getMapper(){
        return new RowMapper<TestPlanDB>() {
            public TestPlanDB mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestPlanDB test = new TestPlanDB(rs.getString("name"),
                        rs.getString("descr"));
                return test;
            }
        };
    }

    @Override 
    protected String tableName(){ return "testplan";}
    
    @Override
    protected String queryForUpdate(TestPlanDB object) {
        return "update from "+tableName()+" where id = "+ object.getId();
    }

    @Override
    protected String queryForPersist(TestPlanDB object){
        return "insert into "+tableName()+" (id, name, descr) values ("+object.getId()+",\"" +
                object.getName()+"\",\""+object.getDescription()+"\")";
    }

    @Override
    protected String queryForDelete(TestPlanDB object){
        return "delete from "+tableName()+" where id = "+ object.getId();
    }

}
