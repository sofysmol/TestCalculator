package sofysmo.testCalculator.data;

/**
 * Created by sofysmo on 19.12.16.
 */
public class TestCase extends Identified<Integer> {
    private String name;
    private String description;
    private String input;
    private String output;

    public TestCase(Integer id, String name, String description, String input, String output) {
        super(id);
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
