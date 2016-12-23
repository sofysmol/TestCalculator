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
    private String k1;
    private String k2;
    private String k3;
    private String k4;
    private String k5;
    private String k6;
    private String k7;
    private String k8;
    private String k9;
    private String k0;
    private String plus;
    private String minus;
    private String div;
    private String mul;
    private String clear;

    @JsonCreator
    public TestConfig(@JsonProperty("deviceName") String deviceName,
                      @JsonProperty("platformVersion") String planformVersion,
                      @JsonProperty("path") String path,
                      @JsonProperty("input") String input,
                      @JsonProperty("output") String output,
                      @JsonProperty("button") String button,
                      @JsonProperty("k1") String k1,
                      @JsonProperty("k2") String k2,
                      @JsonProperty("k3") String k3,
                      @JsonProperty("k4") String k4,
                      @JsonProperty("k5") String k5,
                      @JsonProperty("k6") String k6,
                      @JsonProperty("k7") String k7,
                      @JsonProperty("k8") String k8,
                      @JsonProperty("k9") String k9,
                      @JsonProperty("k0") String k0,
                      @JsonProperty("plus") String plus,
                      @JsonProperty("minus") String minus,
                      @JsonProperty("div") String div,
                      @JsonProperty("mul") String mul,
                      @JsonProperty("clear") String clear) {
        this.deviceName = deviceName;
        this.planformVersion = planformVersion;
        this.path = path;
        this.input = input;
        this.output = output;
        this.button = button;
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.k4 = k4;
        this.k5 = k5;
        this.k6 = k6;
        this.k7 = k7;
        this.k8 = k8;
        this.k9 = k9;
        this.k0 = k0;
        this.plus = plus;
        this.minus = minus;
        this.div = div;
        this.mul = mul;
        this.clear = clear;
    }

    public String getMul() {
        return mul;
    }

    public String getK2() {
        return k2;
    }

    public String getK3() {
        return k3;
    }

    public String getK4() {
        return k4;
    }

    public String getK5() {
        return k5;
    }

    public String getK6() {
        return k6;
    }

    public String getK7() {
        return k7;
    }

    public String getK8() {
        return k8;
    }

    public String getK9() {
        return k9;
    }

    public String getK0() {
        return k0;
    }

    public String getMinus() {
        return minus;
    }

    public String getDiv() {
        return div;
    }

    public String getClear() {
        return clear;
    }

    public String getK1() {
        return k1;
    }

    public String getPlus() {
        return plus;
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
