import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class BaseTest {
    private AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    //лучше не менять, стандартное название метода аппиума. именно так он понимает откуда брать параметры
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        // для андройда валью может быть любым а для айоса должно четко соответствовать названию девайса
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\Dell\\Desktop\\appium\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    public WebElement waitForElementPrsenetBy(By by, String erroeMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(erroeMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }


    public WebElement waitForElementPrsenetBy(By by, String errorMessage) {

        return waitForElementPrsenetBy(by, errorMessage, 10);
    }

    public WebElement waitForElementAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendkeys(By by, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(by, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresented(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private boolean waitForListOfWebElementsNotPresented(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int x = size.width/2;
        int start_y = (int) (size.height*0.8);
        int end_y = (int) ( size.height * 0.2);

        //perform  отправляет всю последовательность действий на выполнение
        action
                .press(point(x, start_y))
                .waitAction(waitOptions(ofSeconds(timeOfSwipe)))
                .moveTo(point(x, end_y))
                .release()
                .perform();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
