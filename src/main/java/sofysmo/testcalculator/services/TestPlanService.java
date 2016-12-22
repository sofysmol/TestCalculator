package sofysmo.testcalculator.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofysmo.testcalculator.dao.TestPlanDao;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.database.TestPlanDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sofysmo on 21.12.16.
 */
@Service
public class TestPlanService {
    private TestPlanDao testPlanDao;

    private TestCaseService testCaseService;

    @Autowired
    public TestPlanService(TestPlanDao testPlanDao, TestCaseService testCaseService){
        this.testPlanDao = testPlanDao;
        this.testCaseService = testCaseService;
    }

    public TestPlan createOrUpdate(TestPlan t){
        TestPlanDB tp = toTestPlanDB(t);
        List<TestCase> tests = new ArrayList<>();
        if(testPlanDao.getByPK(tp) == null) {
            tp = testPlanDao.persist(tp);
            Integer idPlan = tp.getId();
            t.getTests().stream().forEach((tc) ->
                tests.add(testCaseService.createOrUpdate(tc, idPlan)));
        }else{
            tp = testPlanDao.update(tp);
            Integer idPlan = tp.getId();
            testCaseService.deleteAllByIdPlan(idPlan);
            t.getTests().stream().forEach((tc) ->
                    tests.add(testCaseService.create(tc, idPlan)));
        }
        return toTestPlan(tp, tests);
    }

    public List<TestPlan> getAll(){
        return testPlanDao.getAll().stream().map((t) -> {
            List<TestCase> tests = testCaseService.getByIdPlan(t.getId());
            return toTestPlan(t, tests);
        }).collect(Collectors.toList());
    }

    public void delete(String name){
        testPlanDao.delete(new TestPlanDB(name,""));
    }

    private TestPlanDB toTestPlanDB(TestPlan tc){
        return new TestPlanDB(tc.getName(),tc.getDescription());
    }
    private TestPlan toTestPlan(TestPlanDB tc, List<TestCase> tests){
        return new TestPlan(tc.getName(),tc.getDescription(),tests);
    }
}
