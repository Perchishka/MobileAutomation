package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search…')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                    "//*[@text='{SUBSTRING}']",
            SEARCH_RESULTS_LIST_ELEMENTS = "//*[@resource-id='org.wikipedia:id/page_list_item_container']",
            SEARCH_RESULTS_LIST_TITLE = "//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                    "//*[@resource-id='org.wikipedia:id/page_list_item_title']",
            SEARCH_BACK_BUTTON = "//*[@resource-id='org.wikipedia:id/search_toolbar']" +
                    "//*[@class='android.widget.ImageButton']",
           SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION =
                   "//*[@resource-id='org.wikipedia:id/page_list_item_container' and android.widget.LinearLayout[android.widget.TextView[contains(@text,'{TITLE}')] " +
                           "and android.widget.TextView[contains(@text,'{DESCRIPTION}')] ]]",
EMPTY_SEARCH="//*[@text='No results found']",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),
                "Cannot find and click search_init_element ", 15);
        this.waitForElementPrsenetBy(By.xpath(SEARCH_INPUT),
                "Cannot find search_input and after clicking search init element");
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendkeys(By.xpath(SEARCH_INPUT),
                "Cannot find and type into search input", searchLine, 15);
    }

    public WebElement waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        return this.waitForElementPrsenetBy(By.xpath(search_result_xpath),
                "Cannot find search result with substring " + substring);
    }

    public WebElement waitForEmptyResultLable() {
        return this.waitForElementPrsenetBy(By.xpath(EMPTY_SEARCH),
                "Cannot find empty search result lable");
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPrsenetBy(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancell button");
    }

    public void waitForCancelButtonToDisppear() {
        this.waitForElementNotPresented(By.id(SEARCH_CANCEL_BUTTON),
                "Search cancell button is still present", 15);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON),
                "Cannot find and click search cancrl button", 15);
    }

    public void clickBackButton() {
        this.waitForElementAndClick(By.xpath(SEARCH_BACK_BUTTON),
                " Cannot find back button", 15);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),
                "Cannot find and click search result with substring " + substring, 15);
    }

    public List<WebElement> getListofArticlesByTitle() {
        waitForCancelButtonToAppear();
        return this.getListofWebElement(By.xpath(SEARCH_RESULTS_LIST_TITLE),
                "Canot find list of webelements", 15);
    }

    public int getAmountOfElements(){
        return getListofArticlesByTitle().size();
    }

    public List<WebElement> getListofArticles() {
        waitForCancelButtonToAppear();
        return this.getListofWebElement(By.xpath(SEARCH_RESULTS_LIST_ELEMENTS),
                "Canot find list of webelements", 15);
    }

    public WebElement waitForElementByTitleAndDescription(String title, String description) {
        String search_result_xpath = getResultByTitleAndDEscription(title, description);
        System.out.println("element with tittle: "+title +" and description: "+description+" was found");
       return this.waitForElementPrsenetBy(By.xpath(search_result_xpath),
               "Cannot find element with tittle: "+title +" and description: "+description);
    }

    public void assertElementNotPresent(String error_message) {
        int amount_of_elements = getAmountOfElements();
        if (amount_of_elements > 0) {
            String default_message = "An elements supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }




    /*TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultByTitleAndDEscription(String title, String description) {
        return SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION.replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);
    }



    /*TEMPLATES METHODS*/
}
