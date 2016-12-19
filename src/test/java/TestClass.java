import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Created by sofysmo on 18.12.16.
 */
///usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
public class TestClass {
    private AppiumDriver<AndroidElement> driver;
    @Before
    public void setUp() throws Exception {
        File app = new File("/home/sofysmo/IdeaProjects/TestCalculator/src/test/resourses", "Calculator.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Meizu m2");
        capabilities.setCapability("platformVersion", "5.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void addContact(){
        //MobileElement input = driver.findElement(By.id("com.meizu.flyme.calculator:id/edit_text"));
        MobileElement button = driver.findElement(By.id("com.meizu.flyme.calculator:id/clear"));
        button.click();
    }

}
