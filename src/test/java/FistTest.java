import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FistTest {
    private AppiumDriver driver;


    //лучше не менять, стандартное название метода аппиума. именно так он понимает откуда брать параметры
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        // для андройда валью может быть любым а для айоса должно четко соответствовать названию девайса
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\Dell\\Desktop\\appium\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void textBeforeSearch() {
        String searchResult = waitForElementPrsenetBy(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search field was not foud")
                .getAttribute("text");
        System.out.println(searchResult);
        Assert.assertTrue(searchResult.contains("Search"));
    }

    @Test
    public void searchWodaAndAfterCheckInvisibilitiOf3Elements() {
        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search input", 5);

        waitForElementAndSendkeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Cannot find search input", "Java", 5);

        ArrayList<WebElement> list = new ArrayList<>();

       WebElement firstArticle = waitForElementPrsenetBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Object-oriented programming language']"),
                "Java element was not found", 15);
       list.add(firstArticle);

        WebElement secondArticle = waitForElementPrsenetBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Island of Indonesia']"),
                "Java element was not found", 15);
        list.add(secondArticle);

        WebElement thirdArticle = waitForElementPrsenetBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Programming language']"),
                "Java element was not found", 15);
        list.add(thirdArticle);
        list.stream().forEach(i-> System.out.println(i.getAttribute("text")));

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_toolbar']" +
                        "//*[@class='android.widget.ImageButton']"),
                "Java element was not found", 15);

        waitForElementPrsenetBy(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search field was not foud")
                .getAttribute("text");

       //Assert.assertTrue(waitForListOfWebElementsNotPresented(list));
        Assert.assertTrue(waitForElementNotPresented( By.xpath
                        ("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Object-oriented programming language']"),
                "Java element was not found", 15));
        Assert.assertTrue(waitForElementNotPresented( By.xpath
                        ("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Island of Indonesia']"),
                "Java element was not found", 15));
        Assert.assertTrue(waitForElementNotPresented( By.xpath
                        ("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                                "//*[@text='Programming language']"),
                "Java element was not found", 15));


    }

    @Test
    public void searchForTheWord(){
        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search input", 5);

        waitForElementAndSendkeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Cannot find search input", "Java", 5);

        waitForElementPrsenetBy(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find SearchInput",
                15);

        List<WebElement> elements = driver.findElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
        System.out.println(elements.size());

        elements.stream().allMatch(t->t.getAttribute("text").contains("Java"));

    }



   /* @Test
    public void testCancelSearch() {
        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
                "Cannot find SearchInput",
                15);

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find SearchInput",
                15);

        waitForElementNotPresented(By.id("org.wikipedia:id/search_close_btn"),
                "Element is still presented on the page",
                15);
    }*/
   /* @Test
    public void firstTest() {

        waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find SearchInput", 5);

        waitForElementAndSendkeys(By.xpath("//*[contains(@text, 'Search…')]"),
                "Cannot find search input", "Java", 5);


        waitForElementPrsenetBy(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                        "//*[@text='Object-oriented programming language']"),
                "Java element was not found", 15);
        //System.out.println("First test run");
    }*/

    private WebElement waitForElementPrsenetBy(By by, String erroeMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(erroeMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }


    private WebElement waitForElementPrsenetBy(By by, String errorMessage) {

        return waitForElementPrsenetBy(by, errorMessage, 10);
    }

    private WebElement waitForElementAndClick(By by, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(by, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendkeys(By by, String errorMessage, String value, long timeoutInSeconds) {
        WebElement element = waitForElementPrsenetBy(by, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresented(By by, String errorMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private boolean waitForListOfWebElementsNotPresented(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
}


}
