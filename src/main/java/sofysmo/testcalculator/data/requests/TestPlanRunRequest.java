package sofysmo.testcalculator.data.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestConfig;
import sofysmo.testcalculator.data.TestPlan;

/**
 * Created by sofysmo on 22.12.16.
 */
public class TestPlanRunRequest {
    private TestConfig config;
    private TestPlan testPlan;

    @JsonCreator
    public TestPlanRunRequest(@JsonProperty("config") TestConfig config,@JsonProperty("testPlan") TestPlan testPlan) {
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
