package sofysmo.testcalculator.data.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestConfig;
import sofysmo.testcalculator.data.TestPlan;

/**
 * Created by sofysmo on 22.12.16.
 */

public class TestCaseRunRequest {
    private TestConfig config;
    private TestCase testCase;

    @JsonCreator
    public TestCaseRunRequest(@JsonProperty("config") TestConfig config,
                              @JsonProperty("testCase") TestCase testCase) {
        this.config = config;
        this.testCase = testCase;
    }

    public TestConfig getConfig() {
        return config;
    }

    public TestCase getTestCase() {
        return testCase;
    }
}
