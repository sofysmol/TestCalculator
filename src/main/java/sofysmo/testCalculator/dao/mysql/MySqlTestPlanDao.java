package sofysmo.testCalculator.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import sofysmo.testCalculator.dao.TestPlanDao;
import sofysmo.testCalculator.data.database.TestPlanDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlTestPlanDao extends AbstractJDBCDao<TestPlanDB, Integer> implements TestPlanDao {

    @Autowired
    public MySqlTestPlanDao(Connection connection){
        super(connection);
    }

    private String tableName = "TestPlanDB";
    public String getSelectQuery(){
        return "SELECT * FROM " + tableName;
    }

    public String getDeleteQuery(){
        return "DELETE FROM "+ tableName + " WHERE id = ?";
    }

    public String getUpdateQuery(){
        return "UPDATE FROM "+ tableName + " WHERE id = ?";
    }

    public String getCreateQuery(){
        return "INSERT INTO " +tableName+ "(name, descr) VALUES (?,?,?,?,?)";
    }

    public void prepareStatementForUpdate(PreparedStatement statement, TestPlanDB object){

    }

    public void prepareStatementForDelete(PreparedStatement statement, TestPlanDB object){

    }

    public void prepareStatementForInsert(PreparedStatement statement, TestPlanDB object){

    }

    protected List<TestPlanDB> parseResultSet(ResultSet rs){
        return new ArrayList<>();
    }
}
