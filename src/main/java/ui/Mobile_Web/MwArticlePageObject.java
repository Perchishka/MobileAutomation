package ui.Mobile_Web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class MwArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:li#ca-watch[title='Watch this page']";     //"css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        OPTIONS_REMOVE_FROM_MY_LIST="css:#page-actions li#ca-watch.mw-ui-icon-mf-watched button";
    }

    public MwArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

