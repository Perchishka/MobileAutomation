package ui;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class MainPageObject {

    public AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
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

    public WebElement waitForElementClearAndSendkeys(By by, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(by, errorMessage, timeoutInSeconds);
        element.clear();
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresented(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int start_y = (int) (size.height * 0.82);
        int end_y = (int) (size.height * 0.2);

        //perform  отправляет всю последовательность действий на выполнение
        action
                .press(point(x, start_y))
                .waitAction(waitOptions(ofMillis(timeOfSwipe)))
                .moveTo(point(x, end_y))
                .release()
                .perform();
    }

    protected void swipeupQuick() {
        swipeUp(1);
    }

    public void swipeUpToFindElement(By by, String error_message, int max_swipes) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPrsenetBy(by, "Cannot find element by swiping up. \n" + error_message,
                        0);
                return;
            }
            swipeupQuick();
            already_swiped++;
        }
    }

    public void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPrsenetBy(by, error_message, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(point(right_x, middle_y))
                .waitAction(waitOptions(ofMillis(300)))
                .moveTo(point(left_x, middle_y))
                .release()
                .perform();
    }
    public List<WebElement> getListofWebElement(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void switchToframe(int framenumber) {
        driver.switchTo().frame(framenumber);
    }

}
