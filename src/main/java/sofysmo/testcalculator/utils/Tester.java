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

    MobileElement input;
    MobileElement output;
    MobileElement button;
    MobileElement k1;
    MobileElement k2;
    MobileElement k3;
    MobileElement k4;
    MobileElement k5;
    MobileElement k6;
    MobileElement k7;
    MobileElement k8;
    MobileElement k9;
    MobileElement k0;
    MobileElement plus;
    MobileElement minus;
    MobileElement div;
    MobileElement mul;
    MobileElement clear;

    public void setUp(TestConfig testConfig) throws Exception {
        config = testConfig;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName",config.getDeviceName());
        capabilities.setCapability("platformVersion", config.getPlanformVersion());
        capabilities.setCapability("app", config.getPath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        input= driver.findElement(By.id(config.getInput()));
        output = driver.findElement(By.id(config.getOutput()));
        button = driver.findElement(By.id(config.getButton()));
        k1 = driver.findElement(By.id(config.getK1()));
        k2 = driver.findElement(By.id(config.getK2()));
        k3 = driver.findElement(By.id(config.getK3()));
        k4 = driver.findElement(By.id(config.getK4()));
        k5 = driver.findElement(By.id(config.getK5()));
        k6 = driver.findElement(By.id(config.getK6()));
        k7 = driver.findElement(By.id(config.getK7()));
        k8 = driver.findElement(By.id(config.getK8()));
        k9 = driver.findElement(By.id(config.getK9()));
        k0 = driver.findElement(By.id(config.getK0()));
        plus = driver.findElement(By.id(config.getPlus()));
        minus = driver.findElement(By.id(config.getMinus()));
        div = driver.findElement(By.id(config.getDiv()));
        mul = driver.findElement(By.id(config.getMul()));
        clear = driver.findElement(By.id(config.getClear()));
    }

    public TestResult run(TestCase testCase) {
        clear.click();
        for (char ch : testCase.getInput().toCharArray())
            switch (ch) {
                case '1':
                    k1.click();
                    break;
                case '2':
                    k2.click();
                    break;
                case '3':
                    k3.click();
                    break;
                case '4':
                    k4.click();
                    break;
                case '5':
                    k5.click();
                    break;
                case '6':
                    k6.click();
                    break;
                case '7':
                    k7.click();
                    break;
                case '8':
                    k8.click();
                    break;
                case '9':
                    k9.click();
                    break;
                case '0':
                    k0.click();
                    break;
                case '+':
                    plus.click();
                    break;
                case '*':
                    mul.click();
                    break;
                case '-':
                    minus.click();
                    break;
                case '/':
                    div.click();
                    break;
            }
        button.click();
        String res = output.getText();
        if(res.equals(testCase.getOutput()))
            return new TestResult(true, "Success");
        return new TestResult(false, "Error: expected "+testCase.getOutput()+", actually "+ res);
    }


    public void tearDown() throws Exception {
        driver.quit();
    }
}
