package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;

public class BaseTest extends TestCase {
    public AppiumDriver driver;
    protected DevicePlatform platform;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver = DevicePlatform.getInstance().getDriver();
        this.rotateScreenPortrait();

    }

    private void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }


    @Override
    protected void tearDown() throws Exception {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.quit();
        super.tearDown();
    }


}
