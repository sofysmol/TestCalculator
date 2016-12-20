package sofysmo.testcalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofysmo.testcalculator.dao.TestPlanDao;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.services.AppService;

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
