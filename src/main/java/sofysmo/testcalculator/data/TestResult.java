package sofysmo.testcalculator.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sofysmo on 22.12.16.
 */
public class TestResult {
    Boolean result;

    @JsonCreator
    public TestResult(@JsonProperty("result")Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }
}
