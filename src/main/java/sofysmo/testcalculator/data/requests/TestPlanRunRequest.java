package sofysmo.testcalculator.data.requests;

import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestConfig;
import sofysmo.testcalculator.data.TestPlan;

/**
 * Created by sofysmo on 22.12.16.
 */
public class TestPlanRunRequest {
    private TestConfig config;
    private TestPlan testPlan;

    public TestPlanRunRequest(TestConfig config, TestPlan testPlan) {
        this.config = config;
        this.testPlan = testPlan;
    }

    public TestConfig getConfig() {
        return config;
    }

    public TestPlan getTestPlan() {
        return testPlan;
    }
}
