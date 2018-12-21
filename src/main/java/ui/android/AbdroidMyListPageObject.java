package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.MyListsPageObject;

public class AbdroidMyListPageObject extends MyListsPageObject {
    static{
        ARTICLE_BY_TITLE_TPL ="xpath://*[@text='{TITLE}']";
                FOLDER_NAME_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']";
    }

    public AbdroidMyListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
