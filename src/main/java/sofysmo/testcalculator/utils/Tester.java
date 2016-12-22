package sofysmo.testcalculator.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import sofysmo.testcalculator.data.TestCase;
import sofysmo.testcalculator.data.TestConfig;
import sofysmo.testcalculator.data.TestResult;

import java.io.File;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by sofysmo on 22.12.16.
 */
public class Tester {

    private AppiumDriver<AndroidElement> driver;

    private TestConfig config;

    public void setUp(TestConfig testConfig) throws Exception {
        config = testConfig;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName",config.getDeviceName());
        capabilities.setCapability("platformVersion", config.getPlanformVersion());
        capabilities.setCapability("app", config.getPath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public TestResult run(TestCase testCase){
        MobileElement input = driver.findElement(By.id(config.getInput()));
        MobileElement output = driver.findElement(By.id(config.getOutput()));
        MobileElement button = driver.findElement(By.id(config.getButton()));
        input.sendKeys(testCase.getInput());
        button.click();
        if(output.getText().equals(testCase.getOutput()))
            return new TestResult(true);
        return new TestResult(false);
    }

    public void tearDown() throws Exception {
        driver.quit();
    }
}
