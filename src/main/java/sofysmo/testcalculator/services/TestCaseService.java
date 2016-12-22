package sofysmo.testcalculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofysmo.testcalculator.dao.TestCaseDao;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.database.TestCaseDB;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sofysmo on 21.12.16.
 */
@Service
public class TestCaseService {
    private TestCaseDao testCaseDao;

    @Autowired
    public TestCaseService(TestCaseDao testCaseDao){
        this.testCaseDao = testCaseDao;
    }

    public List<TestCase> getAll(){
        return testCaseDao.getAll().stream()
                .map((t) -> toTestCase(t))
                .collect(Collectors.toList());
    }
    
    public TestCase createOrUpdate(TestCase t, Integer idPlan) {
        TestCase tc;
        TestCaseDB tcdb = toTestCaseDB(t, idPlan);
        if(testCaseDao.getByPK(tcdb) == null){
            tc = create(t, idPlan);
        } else {
            tcdb = testCaseDao.update(tcdb);
            tc = toTestCase(tcdb);
        }
        return tc;
    }

    public TestCase create(TestCase t, Integer idPlan) {
        return toTestCase(testCaseDao.persist(toTestCaseDB(t,idPlan)));
    }

    public void deleteAllByIdPlan(Integer id){
       testCaseDao.getByTestPlan(id)
               .stream()
               .forEach((t) -> testCaseDao.delete(t));
    }

    public void delete(String name, String planName){
        testCaseDao.delete(new TestCaseDB(name,"","", "", planName.hashCode()));
    }

    public List<TestCase> getByIdPlan(Integer id){
        return testCaseDao.getByTestPlan(id)
                .stream()
                .map((t) -> toTestCase(t)).collect(Collectors.toList());
    }

    private TestCaseDB toTestCaseDB(TestCase tc, Integer idCase){
        return new TestCaseDB(tc.getName(),tc.getDescription(),tc.getInput(),tc.getOutput(),idCase);
    }
    private TestCase toTestCase(TestCaseDB tc){
        return new TestCase(tc.getName(),tc.getDescription(), tc.getInput(), tc.getOutput());
    }
}
