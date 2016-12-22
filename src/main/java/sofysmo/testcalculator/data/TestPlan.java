package sofysmo.testcalculator.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofysmo on 21.12.16.
 */
public class TestPlan {
    private String name;
    private String description;
    private List<TestCase> tests;

    @JsonCreator
    public TestPlan(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("tests") List<TestCase> tests) {
        this.name = name;
        this.description = description;
        if(tests == null) this.tests = new ArrayList<>();
        else this.tests = tests;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<TestCase> getTests() {
        return tests;
    }
}
