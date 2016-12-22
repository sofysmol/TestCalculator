package sofysmo.testcalculator.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sofysmo on 22.12.16.
 */
public class TestConfig {
    private String deviceName;
    private String planformVersion;
    private String path;
    private String input;
    private String output;
    private String button;

    @JsonCreator
    public TestConfig(@JsonProperty("deviceName") String deviceName,
                      @JsonProperty("platformVersion") String planformVersion,
                      @JsonProperty("path") String path,
                      @JsonProperty("input") String input,
                      @JsonProperty("output") String output,
                      @JsonProperty("button") String button) {
        this.deviceName = deviceName;
        this.planformVersion = planformVersion;
        this.path = path;
        this.input = input;
        this.output = output;
        this.button = button;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlanformVersion() {
        return planformVersion;
    }

    public String getPath() {
        return path;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public String getButton() {
        return button;
    }
}
