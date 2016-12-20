package sofysmo.testCalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofysmo.testCalculator.dao.TestCaseDao;
import sofysmo.testCalculator.dao.TestPlanDao;
import sofysmo.testCalculator.data.TestCase;
import sofysmo.testCalculator.data.TestPlan;
import sofysmo.testCalculator.services.AppService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 17.10.16.
 */
@RestController
public class AppController {
    @Autowired
    AppService service;

    @Autowired
    TestPlanDao testPlan;
    @RequestMapping(value = "/testcases")
    ResponseEntity<List<TestCase>> getTestCase() {
        return new ResponseEntity<List<TestCase>>(new ArrayList<>(), HttpStatus.OK);
    }

    @RequestMapping("/testplans")
    ResponseEntity<List<TestPlan>> getTestPlan() {
        return new ResponseEntity<List<TestPlan>>(new ArrayList<>(), HttpStatus.OK);
    }
}
