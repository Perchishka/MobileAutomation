import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;

public class SwipeTest extends BaseTest {
    BaseTest test = new BaseTest();
    AppiumDriver driver = test.getDriver();

    @Test
    public void swipeUpTest() {
        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search input", 5);

        waitForElementAndSendkeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Cannot find search input", "Java", 5);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Object-oriented programming language']"),
                "Java element was not found", 15);

        waitForElementPrsenetBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page Title was not found", 15);
        swipeUp(2);

    }

    @Test
    public void swipeTillElementTest(){
        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search input", 5);

        waitForElementAndSendkeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Cannot find search input", "Appium", 5);

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']" +
                        "[@text='Appium']"),
                "Java element was not found", 15);

        waitForElementPrsenetBy(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Page Title was not found", 15);

        swipeUpToFindElement(By.xpath("//*[@text='View page in browser']"),
                "Footer was not found",
                20);
    }

}
