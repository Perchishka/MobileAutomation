package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.MyListsPageObject;

public class IOSMyListPageObject extends MyListsPageObject {

    static{
        ARTICLE_BY_TITLE_TPL ="XCUIElementTypeLink[contains(@name='{TITLE}')]";

    }
    public IOSMyListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
