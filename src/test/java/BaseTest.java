import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class BaseTest extends TestCase {
    AppiumDriver driver;

    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    //лучше не менять, стандартное название метода аппиума. именно так он понимает откуда брать параметры

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        // для андройда валью может быть любым а для айоса должно четко соответствовать названию девайса
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\JAVA\\WORK\\mobileAutomation\\libs\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL(APPIUM_URL), capabilities);

    }


    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

}
