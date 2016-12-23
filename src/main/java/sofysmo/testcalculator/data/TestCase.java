package sofysmo.testcalculator.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sofysmo on 21.12.16.
 */
public class TestCase {
    private String name;
    private String description;
    private String inp;
    private String out;

    @JsonCreator
    public TestCase(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("inp") String inp,
                    @JsonProperty("out") String out) {
        this.name = name;
        this.description = description;
        this.inp = inp;
        this.out = out;
    }

    public TestCase(TestCase t){
        this.name = t.getName();
        this.description = t.getDescription();
        this.inp = t.getInput();
        this.out = t.getOutput();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInput() {
        return inp;
    }

    public String getOutput() {
        return out;
    }
}
