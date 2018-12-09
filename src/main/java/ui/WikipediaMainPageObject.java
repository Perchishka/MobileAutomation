package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class WikipediaMainPageObject extends MainPageObject{

    private static final String
            MAIN_PAGE_HEADER="//*[@resource-id='org.wikipedia:id/single_fragment_toolbar']" +
            "//*[@resource-id='org.wikipedia:id/single_fragment_toolbar_wordmark']";

    public WikipediaMainPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForHeader() {
        this.waitForElementPrsenetBy(By.xpath(MAIN_PAGE_HEADER), " Cannot find header");
    }
}
