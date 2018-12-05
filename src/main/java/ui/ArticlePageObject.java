package ui;

import io.appium.java_client.AppiumDriver;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    public static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",

            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPrsenetBy(By.id(TITLE),
                "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT), "Cannot find the end of article", 20
        );
    }

    public void clickOnAddToMyListButton() {

        this.waitForElementAndClick(By.xpath(OPTIONS_BUTTON),
                "Cannot find first button to open article options", 15);

        this.waitForElementAndClick(By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Element from DropdownList didnt find", 15);
    }

    public void addArticleToMyListIfFolderDoesntExist(String nameOffolder) {

        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Overlay button was not found", 15);

        this.waitForElementClearAndSendkeys(By.id(MY_LIST_NAME_INPUT),
                "Cannot find text field for set name",
                nameOffolder, 15);

        this.waitForElementAndClick(By.xpath(MY_LIST_OK_BUTTON),
                "Cannot find ok button", 20);
    }

    public void closeArticle() {
        this.waitForElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot find first button to close article", 15);
    }




}
