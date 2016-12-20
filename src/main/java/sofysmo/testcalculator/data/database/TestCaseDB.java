package sofysmo.testcalculator.data.database;

import sofysmo.testcalculator.data.Identified;

/**
 * Created by sofysmo on 19.12.16.
 */
public class TestCaseDB extends Identified<Integer> {
    private String name;
    private String description;
    private String input;
    private String output;
    private Integer idPlan;

    public TestCaseDB(Integer id, String name, String description, String input, String output, Integer idPlan) {
        super(id);
        this.name = name;
        this.description = description;
        this.input = input;
        this.output = output;
        this.idPlan = idPlan;
    }

    public Integer getIdPlan() {
        return idPlan;
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
