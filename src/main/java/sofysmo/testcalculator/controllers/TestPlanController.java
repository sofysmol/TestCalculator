package sofysmo.testcalculator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.respones.SimpleResponse;
import sofysmo.testcalculator.services.TestPlanService;

import java.util.List;

/**
 * Created by sofysmo on 17.10.16.
 */
@RestController
public class TestPlanController {
    private Logger logger = LoggerFactory.getLogger(TestPlanController.class);
    @Autowired
    TestPlanService serviceTP;

    @RequestMapping("/testplans")
    ResponseEntity<List<TestPlan>> getTestPlans() {
        return new ResponseEntity<List<TestPlan>>(serviceTP.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/testplan", method = {RequestMethod.PUT})
    ResponseEntity<TestPlan> createOrUpdateTestPlan(@RequestBody TestPlan tp){
        return new ResponseEntity<TestPlan>(serviceTP.createOrUpdate(tp), HttpStatus.OK);
    }

    @RequestMapping(value = "/testplan", method = {RequestMethod.DELETE})
    ResponseEntity<SimpleResponse> deleteTestPlan(@RequestParam String name){
        serviceTP.delete(name);
        return new ResponseEntity<SimpleResponse>(new SimpleResponse("Deleted testplan", 200), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<SimpleResponse> handleException(Exception e){
        logger.error("Exception during execution:", e);
        return new ResponseEntity<SimpleResponse>(new SimpleResponse("Server error",500), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
