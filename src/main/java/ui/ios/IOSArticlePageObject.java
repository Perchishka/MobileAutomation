package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
            TITLE = "id:Java (programming language)";
            FOOTER_ELEMENT = "id:View page in browser";
            CLOSE_ARTICLE_BUTTON = "id:Back";
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
            PLACES_WITH_AUTOCLOSE="id:places auth close";
        }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
