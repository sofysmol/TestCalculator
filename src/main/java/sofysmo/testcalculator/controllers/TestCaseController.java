package sofysmo.testcalculator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.requests.TestCaseRequest;
import sofysmo.testcalculator.data.respones.SimpleResponse;
import sofysmo.testcalculator.services.TestCaseService;

import java.util.List;

/**
 * Created by sofysmo on 22.12.16.
 */
@RestController
public class TestCaseController {
    private Logger logger = LoggerFactory.getLogger(TestCaseController.class);
    
    @Autowired
    TestCaseService serviceTC;

    @RequestMapping("/testcases")
    ResponseEntity<List<TestCase>> getTestCase() {
        return new ResponseEntity<List<TestCase>>(serviceTC.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/testcase", method = {RequestMethod.PUT})
    ResponseEntity<TestCase> createOrUpdateTestCase(@RequestBody TestCaseRequest req){
        return new ResponseEntity<TestCase>(serviceTC.createOrUpdate(req.getTest(),req.getNameTestPlan().hashCode()), HttpStatus.OK);
    }

    @RequestMapping(value = "/testcase", method = {RequestMethod.DELETE})
    ResponseEntity<SimpleResponse> deleteTestCase(@RequestParam String name, @RequestParam String planName){
        serviceTC.delete(name, planName);
        return new ResponseEntity<SimpleResponse>(new SimpleResponse("Deleted testplan", 200),
                HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<SimpleResponse> handleException(Exception e){
        logger.error("Exception during execution:", e);
        return new ResponseEntity<SimpleResponse>(new SimpleResponse("Server error", 500),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

