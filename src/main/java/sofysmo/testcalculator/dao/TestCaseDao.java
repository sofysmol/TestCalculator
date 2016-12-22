package sofysmo.testcalculator.dao;

import sofysmo.testcalculator.data.database.TestCaseDB;

import java.util.List;

/**
 * Created by sofysmo on 19.12.16.
 */
public interface TestCaseDao extends GenericDao<TestCaseDB, Integer> {
    List<TestCaseDB> getByTestPlan(Integer id);
}
