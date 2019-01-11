package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WikipediaMainPageObject extends MainPageObject{

    private static final String
            MAIN_PAGE_HEADER="xpath://*[@resource-id='org.wikipedia:id/single_fragment_toolbar']" +
            "//*[@resource-id='org.wikipedia:id/single_fragment_toolbar_wordmark']";

    public WikipediaMainPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForHeader() {
        this.waitForElementPrsenetBy(MAIN_PAGE_HEADER, " Cannot find header");
    }
}
