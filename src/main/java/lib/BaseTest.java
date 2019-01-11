package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.WelcomePageObject;

import java.time.Duration;

public class BaseTest extends TestCase {
    public RemoteWebDriver driver;
    protected DevicePlatform platform;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        driver = DevicePlatform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();

    }

    private void rotateScreenPortrait() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("method rotateScreenPortrait does nothing for platform" + DevicePlatform.getInstance()
                    .getPlatformVar());
        }
    }

    protected void rotateScreenLandscape() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("method rotateScreenLandscape does nothing for platform" + DevicePlatform.getInstance()
                    .getPlatformVar());
        }
    }

    protected void backgroundApp(int seconds) {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        }else{
                System.out.println("method backgroundApp does nothing for platform" + DevicePlatform.getInstance()
                        .getPlatformVar());
            }
        }

        protected void openWikiWebPageForMobileWeb(){
        if(DevicePlatform.getInstance().isMw()){
            driver.get("https://en.m.wikipedia.org");
        }else {
            System.out.println("method openWikiWebPageForMobileWeb does nothing for platform" + DevicePlatform.getInstance()
                    .getPlatformVar());
        }
        }

        private void skipWelcomePageForIOSApp() {
            if (DevicePlatform.getInstance().isIOS()) {
                AppiumDriver driver = (AppiumDriver) this.driver;
                WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
                welcomePageObject.clickSkip();
            }
        }



}
