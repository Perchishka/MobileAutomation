package ui;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class MainPageObject {

    public AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPrsenetBy(String locator, String erroeMessage, long timeoutInSeconds) {
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(erroeMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public String waitForElementAndgetAttribute(String locator, String attribute, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(locator, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }


    public WebElement waitForElementPrsenetBy(String locator, String errorMessage) {

        return waitForElementPrsenetBy(locator, errorMessage, 10);
    }


    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(locator, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendkeys(String locator, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementClearAndSendkeys(String locator, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(locator, errorMessage, timeoutInSeconds);
        element.clear();
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresented(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorString(locator);
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

    public void swipeUpToFindElement(String locator, String error_message, int max_swipes) {
        By by = this.getLocatorString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPrsenetBy(locator, "Cannot find element by swiping up. \n" + error_message,
                        0);
                return;
            }
            swipeupQuick();
            already_swiped++;
        }
    }

    public void swipeElementToLeft(String locator, String error_message) {
        WebElement element = waitForElementPrsenetBy(locator, error_message, 10);
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

    public List<WebElement> getListofWebElement(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorString(locator);
        return driver.findElements(by);
    }

    public void switchToframe(int framenumber) {
        driver.switchTo().frame(framenumber);
    }

    private By getLocatorString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if(by_type.equals("id")) {
            return By.id(locator);
        }else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: "+ locator_with_type);
        }

    }
}
