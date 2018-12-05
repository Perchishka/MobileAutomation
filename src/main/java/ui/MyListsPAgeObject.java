package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPAgeObject extends MainPageObject{
    private static final String
            ARTICLE_BY_TITLE_TPL ="//*[@text='{TITLE}']",
            FOLDER_NAME_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']";


    public MyListsPAgeObject(AppiumDriver driver) {
        super(driver);
    }


    public void clickOnExistingFolder(String folderName) {
        String folder_name_xpath = getFolderXpathByTitle(folderName);
        this.waitForElementAndClick(By.xpath(folder_name_xpath), "Cannot find folder", 15);
    }

    public void swipeByArticleToDelete(String article_title){
        waitForArticleToAapearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(By.xpath(article_title_xpath),
                "Cannot find saved article");
        this.waitForArticleToDisapearByTitle(article_title);
    }

    public void waitForArticleToDisapearByTitle(String article_title){
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresented(By.xpath(article_title_xpath),
                "Saved article is present with title "+article_title, 15);
    }

    public void waitForArticleToAapearByTitle(String article_title){
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPrsenetBy(By.xpath(article_title_xpath),
                "CAnnot fines saved article by title "+article_title, 15);
    }


    /*TEMPLATES METHODS*/
    private static String getFolderXpathByTitle(String substring) {
        return FOLDER_NAME_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticleXpathByTitle(String substring) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLEG}", substring);
    }

    /*TEMPLATES METHODS*/
}
