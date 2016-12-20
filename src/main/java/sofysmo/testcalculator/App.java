package sofysmo.testcalculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

/**
 * Created by sofysmo on 18.12.16.
 */
    public class App
    {
        private static AppiumDriver<AndroidElement> driver;
        public static void setUp() throws Exception {
            File app = new File("/home/sofysmo/IdeaProjects/TestCalculator/src/test/resourses", "Calculator.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName","Meizu m2");
            capabilities.setCapability("platformVersion", "5.1");
            capabilities.setCapability("app", app.getAbsolutePath());
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        public static void tearDown() throws Exception {
            driver.quit();
        }
        public static void main(String[] args) {
            try {
                setUp();
                MobileElement input = driver.findElement(By.id("com.meizu.flyme.calculator:id/edit_text"));
                input.sendKeys("1");
                input.sendKeys("8");
                input.sendKeys("1+27");
                //input.sendKeys("1+8");
                MobileElement button = driver.findElement(By.id("com.meizu.flyme.calculator:id/clear"));
                button.click();
                System.out.println(input.getText());
                tearDown();
            }catch (Exception e){}

        }

    }
