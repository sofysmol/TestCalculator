package sofysmo.testcalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.TestResult;
import sofysmo.testcalculator.data.requests.TestCaseRunRequest;
import sofysmo.testcalculator.data.requests.TestPlanRunRequest;
import sofysmo.testcalculator.services.RunTestService;
import sun.misc.Contended;

import java.util.List;

/**
 * Created by sofysmo on 22.12.16.
 */
@Controller
public class RunTestController {

    @Autowired
    private RunTestService serviceRT;

    @RequestMapping(value = "/run/testcase")
    ResponseEntity<TestResult> runTestCase(@RequestBody TestCaseRunRequest request) throws Exception{
        return new ResponseEntity<TestResult>(serviceRT.runTestCase(request.getTestCase(), request.getConfig()), HttpStatus.OK);
    }

    @RequestMapping(value = "/run/testplan")
    ResponseEntity<List<TestResult>> runTestPlan(@RequestBody TestPlanRunRequest request) throws Exception{
        return new ResponseEntity<List<TestResult>>(serviceRT
                .runTestPlan(request.getTestPlan(),request.getConfig()), HttpStatus.OK);
    }
}
