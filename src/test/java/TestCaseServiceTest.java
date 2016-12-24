import org.junit.Before;
import org.junit.Test;
import sofysmo.testcalculator.dao.TestCaseDao;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.database.TestCaseDB;
import sofysmo.testcalculator.data.database.TestPlanDB;
import sofysmo.testcalculator.services.TestCaseService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by sofysmo on 24.12.16.
 */
public class TestCaseServiceTest {

    private TestCaseDao testCaseDao;
    private TestCaseService service;
    private Integer idPlan = 0;

    private TestCase testCase;
    private TestCaseDB testCaseDB1;
    private TestCaseDB testCaseDB2;
    private ArrayList<TestCaseDB> list;

    @Before
    public void setUp(){
        testCaseDao = mock(TestCaseDao.class);
        service = new TestCaseService(testCaseDao);
        testCase = new TestCase("","","","");
        testCaseDB1 = new TestCaseDB("","","","",idPlan);
        testCaseDB2 = new TestCaseDB("a","","","",idPlan);

        list = new ArrayList<>();
        list.add(testCaseDB1);
        list.add(testCaseDB2);
    }

    @Test
    public void createOrUpdateTest(){
        when(testCaseDao.getByPK(anyObject())).thenReturn(testCaseDB1);
        when(testCaseDao.update(anyObject())).thenReturn(testCaseDB1);
        assertEquals(service.createOrUpdate(testCase,idPlan), testCase);
    }

    @Test
    public void createOrUpdateNullTest(){
        when(testCaseDao.getByPK(anyObject())).thenReturn(null);
        when(testCaseDao.persist(anyObject())).thenReturn(testCaseDB1);
        assertEquals(service.createOrUpdate(testCase,idPlan), testCase);
    }

    @Test
    public void deleteAllTest(){
        when(testCaseDao.getByTestPlan(idPlan)).thenReturn(list);
        service.deleteAllByIdPlan(idPlan);
        verify(testCaseDao).delete(list.get(0));
        verify(testCaseDao).delete(list.get(1));
    }
}
