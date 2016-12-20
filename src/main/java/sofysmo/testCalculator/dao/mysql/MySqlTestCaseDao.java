package sofysmo.testCalculator.dao.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import sofysmo.testCalculator.dao.TestCaseDao;
import sofysmo.testCalculator.data.database.TestCaseDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public class MySqlTestCaseDao extends AbstractJDBCDao<TestCaseDB, Integer> implements TestCaseDao {

    @Autowired
    public MySqlTestCaseDao(Connection connection){
        super(connection);
    }

    private String tableName = "TestCaseDB";
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

    public void prepareStatementForUpdate(PreparedStatement statement, TestCaseDB object){

    }

    public void prepareStatementForDelete(PreparedStatement statement, TestCaseDB object){

    }

    public void prepareStatementForInsert(PreparedStatement statement, TestCaseDB object){

    }

    protected List<TestCaseDB> parseResultSet(ResultSet rs){
        return new ArrayList<>();
    }
}
