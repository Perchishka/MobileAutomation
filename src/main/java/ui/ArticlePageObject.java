package ui;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            PLACES_WITH_AUTOCLOSE,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPrsenetBy(TITLE,
                "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (DevicePlatform.getInstance().isAndroid()) {

            return title_element.getAttribute("text");
        }else if(DevicePlatform.getInstance().isMw()){
                return title_element.getText();
            }
        else {
            return title_element.getAttribute("name");
        }
    }



    public void assertElementPresent(String error_message) {
        String article_title = getArticleTitle();
        if (article_title == null) {
            String default_message = "An elements supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public void swipeToFooter() {
        if (DevicePlatform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 20);
        } else if(DevicePlatform.getInstance().isMw()){
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        } else {
            swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }
    }

    public void clickOnAddToMyListButton() {

        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find first button to open article options", 15);

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Element from DropdownList didnt find", 15);
    }

    public void addArticleToMyListIfFolderDoesntExist(String nameOffolder) {

        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY,
                "Overlay button was not found", 15);

        this.waitForElementClearAndSendkeys(MY_LIST_NAME_INPUT,
                "Cannot find text field for set name",
                nameOffolder, 15);

        this.waitForElementAndClick(MY_LIST_OK_BUTTON,
                "Cannot find ok button", 20);
    }

    public void closeArticle() {
        if((DevicePlatform.getInstance().isAndroid() || DevicePlatform.getInstance().isIOS())){
        this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON,
                "Cannot find first button to close article", 20);}
        else {

        }

    }

    public void addArticleToMySavedIos(){
if(DevicePlatform.getInstance().isMw()){
    removeArticleFromeSavedIfItAdded();
}
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                " Cannot add article to My saved", 15);
        this.waitForElementPrsenetBy("css: .drawer", "error");

    }

    public  void closeAuthWindow(){
        this.waitForElementAndClick(PLACES_WITH_AUTOCLOSE, "Cannot click on autoclose button", 15);
    }

    public void removeArticleFromeSavedIfItAdded(){
        if (isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST)){
            waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST, "cannot click on remove button", 5);
        }
        waitForElementPrsenetBy(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                " cannot find button to  add an articale to my saved list", 5);
    }


}
