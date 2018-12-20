package iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class IOSTestCase extends TestCase {
    AppiumDriver driver;

    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    //лучше не менять, стандартное название метода аппиума. именно так он понимает откуда брать параметры

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        // для андройда валью может быть любым а для айоса должно четко соответствовать названию девайса
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("platformVersion", "11.1");

        capabilities.setCapability("app", "C:\\JAVA\\WORK\\mobileAutomation\\libs\\org.wikipedia.apk"); //ljdbnm genm r dbrbgtlbf fgg

        driver = new IOSDriver(new URL(APPIUM_URL), capabilities);
        this.rotateScreenPortrait();

    }

    protected void rotateScreenPortrait(){driver.rotate(ScreenOrientation.PORTRAIT);}
    protected void rotateScreenLandscape(){driver.rotate(ScreenOrientation.LANDSCAPE);}


    @Override
    protected void tearDown() throws Exception {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.quit();
        super.tearDown();
    }

}
