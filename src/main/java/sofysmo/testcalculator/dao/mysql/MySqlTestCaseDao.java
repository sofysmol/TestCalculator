package sofysmo.testcalculator.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import sofysmo.testcalculator.dao.TestCaseDao;
import sofysmo.testcalculator.data.database.TestCaseDB;
import sofysmo.testcalculator.data.database.TestCaseDB;

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
public class MySqlTestCaseDao extends AbstractJDBCDao<TestCaseDB> implements TestCaseDao {

    @Autowired
    public MySqlTestCaseDao(DataSource dataSource){
        super(dataSource);
    }

    protected RowMapper<TestCaseDB> getMapper(){
        return new RowMapper<TestCaseDB>() {
            public TestCaseDB mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestCaseDB test = new TestCaseDB(rs.getString("name"),
                        rs.getString("descr"), rs.getString("inp"), rs.getString("out"), rs.getInt("idPlan"));
                return test;
            }
        };
    }

    @Override
    protected String tableName(){ return "testcase";}

    @Override
    protected String queryForUpdate(TestCaseDB object) {
        return "update from "+tableName()+" where id = "+ object.getId();
    }

    @Override
    protected String queryForPersist(TestCaseDB object){
        return "insert into "+tableName()+" (id, name, descr, inp, `out`, idPlan) values (" +
                +object.getId() + ",\"" +
                object.getName() + "\",\""+
                object.getDescription() + "\",\""+
                object.getInput() + "\",\"" +
                object.getOutput() +"\",\"" +
                object.getIdPlan()+"\")";
    }

    @Override
    protected String queryForDelete(TestCaseDB object){
        return "delete from "+tableName()+" where id = "+ object.getId();
    }

    @Override
    public List<TestCaseDB> getByTestPlan(Integer id){
       return jdbcTemplate.query("select * from "+tableName()+" where idPlan = " + id, getMapper());
    }
}
