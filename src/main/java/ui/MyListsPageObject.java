package ui;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObject extends MainPageObject{
    protected static String
            ARTICLE_BY_TITLE_TPL,
            FOLDER_NAME_BY_SUBSTRING_TPL,
            REMOVE_FROM_SAVED_BUTTON;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }


    public void clickOnExistingFolder(String folderName) {
        String folder_name_xpath = getFolderXpathByTitle(folderName);
        this.waitForElementAndClick(folder_name_xpath, "Cannot find folder", 15);
    }

    public void swipeByArticleToDelete(String article_title){
        waitForArticleToAapearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);

        if ((DevicePlatform.getInstance().isIOS() || DevicePlatform.getInstance().isAndroid())){
        this.swipeElementToLeft(article_title_xpath,
                "Cannot find saved article");
        if(DevicePlatform.getInstance().isIOS()){
            clickElementToTheRightUpperConer(article_title_xpath, "Cannot find  saved article");
        }

        if(DevicePlatform.getInstance().isMw()){
            driver.navigate().refresh();
        }
        this.waitForArticleToDisapearByTitle(article_title);
    } else {
            String remove_locator = getRemoveButoonByTitle(article_title);
            waitForElementAndClick(remove_locator,
                    "cannot find button to remove article from saved",5);
        }
    }

    public String  getRemoveButoonByTitle(String article_title){
       return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);

    }

    public void waitForArticleToDisapearByTitle(String article_title){
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresented(article_title_xpath,
                "Saved article is present with title "+article_title, 15);
    }

    public void waitForArticleToAapearByTitle(String article_title){
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPrsenetBy(article_title_xpath,
                "CAnnot fines saved article by title "+article_title, 15);
    }


    /*TEMPLATES METHODS*/
    private static String getFolderXpathByTitle(String substring) {
        return FOLDER_NAME_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticleXpathByTitle(String substring) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", substring);
    }

    /*TEMPLATES METHODS*/
}
