package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;
import ui.Mobile_Web.MwNavigationUi;
import ui.NavigationUi;
import ui.android.AndroidArticlePageObject;
import ui.android.AndroidNavigationUI;
import ui.ios.IOSArticlePageObject;
import ui.ios.IOSNavigationUi;

public class NavigationUiFactory {
    public static NavigationUi get(RemoteWebDriver driver) {
        if (DevicePlatform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        }
        else if(DevicePlatform.getInstance().isMw()) {
            return new MwNavigationUi(driver);
        }else
         return new IOSNavigationUi(driver);

    }
}
