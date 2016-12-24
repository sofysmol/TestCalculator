import org.junit.Before;
import org.junit.Test;
import sofysmo.testcalculator.dao.TestCaseDao;
import sofysmo.testcalculator.dao.TestPlanDao;
import sofysmo.testcalculator.dao.TestPlanDao;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.database.TestCaseDB;
import sofysmo.testcalculator.data.database.TestPlanDB;
import sofysmo.testcalculator.services.TestCaseService;
import sofysmo.testcalculator.services.TestPlanService;
import sofysmo.testcalculator.services.TestPlanService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * Created by sofysmo on 24.12.16.
 */
public class TestPlanServiceTest {
    
    private TestPlanDao testPlanDao;
    private TestCaseService testCaseService;

    private TestPlanService service;
    private TestPlan testPlan;
    private TestPlanDB testPlanDB1;

    private ArrayList<TestCase> listOfCases;
    private ArrayList<TestPlan> listOfPlans;
    private ArrayList<TestPlanDB> listOfPlansDB;

    private TestCase testCase1;
    private TestCase testCase2;
    
    @Before
    public void setUp(){
        testPlanDao = mock(TestPlanDao.class);
        testCaseService = mock(TestCaseService.class);

        service = new TestPlanService(testPlanDao, testCaseService);

        testPlanDB1 = new TestPlanDB("","");

        testCase1 = new TestCase("","","","");
        testCase2 = new TestCase("a","","","");

        listOfCases = new ArrayList<>();
        listOfCases.add(testCase1);
        listOfCases.add(testCase2);

        testPlan = new TestPlan("","", listOfCases);

        listOfPlansDB = new ArrayList<>();
        listOfPlansDB.add(testPlanDB1);

        listOfPlans = new ArrayList<>();
        listOfPlans.add(testPlan);

    }

    @Test
    public void createOrUpdateTest(){
        when(testPlanDao.getByPK(anyObject())).thenReturn(testPlanDB1);
        when(testPlanDao.update(anyObject())).thenReturn(testPlanDB1);
        when(testCaseService.createOrUpdate(testCase1,testPlanDB1.getId())).thenReturn(testCase1);
        when(testCaseService.createOrUpdate(testCase2,testPlanDB1.getId())).thenReturn(testCase2);
        TestPlan res = service.createOrUpdate(testPlan);
        verify(testCaseService).deleteAllByIdPlan(anyInt());
        verify(testCaseService, times(2)).createOrUpdate(anyObject(),anyInt());
        assertEquals(res, testPlan);
    }

    @Test
    public void createOrUpdateNullTest(){
        when(testPlanDao.getByPK(anyObject())).thenReturn(null);
        when(testPlanDao.persist(anyObject())).thenReturn(testPlanDB1);
        assertEquals(service.createOrUpdate(testPlan), testPlan);
    }

    @Test
    public void getAllTest(){
        when(testPlanDao.getAll()).thenReturn(listOfPlansDB);
        when(testCaseService.getByIdPlan(anyInt())).thenReturn(listOfCases);
        List<TestPlan> t1 = service.getAll();
        assertTrue(t1.equals(listOfPlans));
    }
}
