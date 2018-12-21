package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import ui.ArticlePageObject;
import ui.NavigationUi;
import ui.android.AndroidArticlePageObject;
import ui.android.AndroidNavigationUI;
import ui.ios.IOSArticlePageObject;
import ui.ios.IOSNavigationUi;

public class NavigationUiFactory {
    public static NavigationUi get(AppiumDriver driver) {
        if (DevicePlatform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        } else return new IOSNavigationUi(driver);
    }
}
