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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestPlan)) return false;

        TestPlan testPlan = (TestPlan) o;

        if (getName() != null ? !getName().equals(testPlan.getName()) : testPlan.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(testPlan.getDescription()) : testPlan.getDescription() != null)
            return false;
        return getTests() != null ? getTests().equals(testPlan.getTests()) : testPlan.getTests() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getTests() != null ? getTests().hashCode() : 0);
        return result;
    }
}
