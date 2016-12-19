package sofysmo.testCalculator.dao.mysql;

import sofysmo.testCalculator.dao.TestCaseDao;
import sofysmo.testCalculator.data.TestCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlTestCaseDao extends AbstractJDBCDao<TestCase, Integer> implements TestCaseDao {


    public MySqlTestCaseDao(Connection connection){
        super(connection);
    }

    private String tableName = "TestCase";
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
        return "INSERT INTO " +tableName+ "(name, descr,idPlan,inp,output) VALUES (?,?,?,?,?)";
    }

    public void prepareStatementForUpdate(PreparedStatement statement, TestCase object){

    }

    public void prepareStatementForDelete(PreparedStatement statement, TestCase object){

    }

    public void prepareStatementForInsert(PreparedStatement statement, TestCase object){

    }

    protected List<TestCase> parseResultSet(ResultSet rs){
        return new ArrayList<>();
    }
}
