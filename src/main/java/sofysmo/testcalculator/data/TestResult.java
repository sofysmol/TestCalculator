package sofysmo.testcalculator.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sofysmo on 22.12.16.
 */
public class TestResult {
    Boolean result;
    String message;

    @JsonCreator
    public TestResult(@JsonProperty("result")Boolean result, @JsonProperty("message") String message) {
        this.result = result;
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
