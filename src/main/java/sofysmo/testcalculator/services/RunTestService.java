package sofysmo.testcalculator.services;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import sofysmo.testcalculator.controllers.TestPlanController;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestConfig;
import sofysmo.testcalculator.data.TestPlan;
import sofysmo.testcalculator.data.TestResult;
import sofysmo.testcalculator.utils.Tester;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sofysmo on 22.12.16.
 */
@Service
public class RunTestService {

    private Logger logger = LoggerFactory.getLogger(RunTestService.class);

    public TestResult runTestCase(TestCase test, TestConfig config) throws Exception{
        Tester tester = new Tester();
        try{
            tester.setUp(config);
            return tester.run(test);
        }finally {
            tester.tearDown();
        }
    }

    public List<TestResult> runTestPlan(TestPlan testPlan, TestConfig config) throws Exception{
        Tester tester = new Tester();
        try{
            tester.setUp(config);
            return testPlan.getTests().stream().map(test -> tester.run(test)).collect(Collectors.toList());
        }finally {
            tester.tearDown();
        }
    }
}
