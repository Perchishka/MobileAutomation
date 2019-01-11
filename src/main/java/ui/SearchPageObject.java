package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

     protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULTS_LIST_ELEMENTS,
            SEARCH_RESULTS_LIST_TITLE,
            SEARCH_BACK_BUTTON,
            SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION,
            EMPTY_SEARCH,
             SEARCH_RESULT_ELEMENT,
            SEARCH_CANCEL_BUTTON;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,
                "Cannot find and click search_init_element ", 15);
        this.waitForElementPrsenetBy(SEARCH_INPUT,
                "Cannot find search_input and after clicking search init element");
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementClearAndSendkeys(SEARCH_INPUT,
                "Cannot find and type into search input", searchLine, 15);
    }
    public void clickSearchLine() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,
                "Cannot find and type into search input",  15);
    }

    public WebElement waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        return this.waitForElementPrsenetBy(search_result_xpath,
                "Cannot find search result with substring " + substring);
    }

    public WebElement waitForEmptyResultLable() {
        return this.waitForElementPrsenetBy(EMPTY_SEARCH,
                "Cannot find empty search result lable");
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPrsenetBy(SEARCH_CANCEL_BUTTON, "Cannot find search cancell button");
    }

    public void waitForCancelButtonToDisppear() {
        this.waitForElementNotPresented(SEARCH_CANCEL_BUTTON,
                "Search cancell button is still present", 15);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON,
                "Cannot find and click search cancrl button", 15);
    }

    public void clickBackButton() {
        this.waitForElementAndClick(SEARCH_BACK_BUTTON,
                " Cannot find back button", 15);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,
                "Cannot find and click search result with substring " + substring, 15);
    }

    public List<WebElement> getListofArticlesByTitle() {
        waitForCancelButtonToAppear();
        return this.getListofWebElement(SEARCH_RESULTS_LIST_TITLE,
                "Canot find list of webelements", 15);
    }

    public int getAmountOfElements() {
        return getListofArticlesByTitle().size();
    }

    public List<WebElement> getListofArticles() {
        waitForCancelButtonToAppear();
        return this.getListofWebElement(SEARCH_RESULTS_LIST_ELEMENTS,
                "Canot find list of webelements", 15);
    }

    public WebElement waitForElementByTitleAndDescription(String title, String description) {
        String search_result_xpath = getResultByTitleAndDEscription(title, description);
        System.out.println("element with tittle: " + title + " and description: " + description + " was found");
        return this.waitForElementPrsenetBy(search_result_xpath,
                "Cannot find element with tittle: " + title + " and description: " + description);
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
