package sofysmo.testcalculator.data.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import sofysmo.testcalculator.data.TestCase;

/**
 * Created by sofysmo on 22.12.16.
 */
public class TestCaseRequest {
    private TestCase test;
    private String nameTestPlan;

    @JsonCreator
    public TestCaseRequest(@JsonProperty("test") TestCase test,
                    @JsonProperty("nameTestPlan") String nameTestPlan) {
        this.test = test;
        this.nameTestPlan = nameTestPlan;
    }

    public TestCase getTest() {
        return test;
    }

    public String getNameTestPlan() {
        return nameTestPlan;
    }
}
