package sofysmo.testCalculator.dao.mysql;

import sofysmo.testCalculator.dao.TestPlanDao;
import sofysmo.testCalculator.data.TestPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlTestPlanDao extends AbstractJDBCDao<TestPlan, Integer> implements TestPlanDao {


    public MySqlTestPlanDao(Connection connection){
        super(connection);
    }

    private String tableName = "TestPlan";
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

    public void prepareStatementForUpdate(PreparedStatement statement, TestPlan object){

    }

    public void prepareStatementForDelete(PreparedStatement statement, TestPlan object){

    }

    public void prepareStatementForInsert(PreparedStatement statement, TestPlan object){

    }

    protected List<TestPlan> parseResultSet(ResultSet rs){
        return new ArrayList<>();
    }
}
