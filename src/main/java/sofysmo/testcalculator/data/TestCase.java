package sofysmo.testcalculator.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sofysmo on 21.12.16.
 */
public class TestCase {
    private String name;
    private String description;
    private String input;
    private String output;

    @JsonCreator
    public TestCase(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("input") String input,
                    @JsonProperty("output") String output) {
        this.name = name;
        this.description = description;
        this.input = input;
        this.output = output;
    }

    public TestCase(TestCase t){
        this.name = t.getName();
        this.description = t.getDescription();
        this.input = t.getInput();
        this.output = t.getOutput();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestCase)) return false;

        TestCase testCase = (TestCase) o;

        if (getName() != null ? !getName().equals(testCase.getName()) : testCase.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(testCase.getDescription()) : testCase.getDescription() != null)
            return false;
        if (getInput() != null ? !getInput().equals(testCase.getInput()) : testCase.getInput() != null) return false;
        return getOutput() != null ? getOutput().equals(testCase.getOutput()) : testCase.getOutput() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getInput() != null ? getInput().hashCode() : 0);
        result = 31 * result + (getOutput() != null ? getOutput().hashCode() : 0);
        return result;
    }
}
