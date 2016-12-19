package sofysmo.testCalculator.data;

/**
 * Created by sofysmo on 19.12.16.
 */
public class TestPlan extends Identified<Integer>{
    private String name;
    private String productName;
    private String description;

    public TestPlan(Integer id, String name, String productName, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
