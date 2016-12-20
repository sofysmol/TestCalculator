package sofysmo.testcalculator.data;

/**
 * Created by sofysmo on 21.12.16.
 */
public class TestCase {
    private String name;
    private String description;
    private String input;
    private String output;

    public TestCase(String name, String description, String input, String output) {
        this.name = name;
        this.description = description;
        this.input = input;
        this.output = output;
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
