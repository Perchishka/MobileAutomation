package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUi;

public class AndroidNavigationUI extends NavigationUi {
    static {
        MY_LISTS_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }
    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
