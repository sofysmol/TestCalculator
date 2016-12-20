package sofysmo.testcalculator.data;

import java.util.List;

/**
 * Created by sofysmo on 21.12.16.
 */
public class TestPlan {
    private String name;
    private String description;
    private List<TestCase> tests;

    public TestPlan(String name, String productName, String description, List<TestCase> tests) {
        this.name = name;
        this.description = description;
        this.tests = tests;
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
