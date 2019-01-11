package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUi;

public class IOSNavigationUi extends NavigationUi {
    static{
        MY_LISTS_BUTTON = "id:Saved";
    }
    public IOSNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
