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
}
