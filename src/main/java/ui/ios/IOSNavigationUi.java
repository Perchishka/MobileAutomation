package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.NavigationUi;

public class IOSNavigationUi extends NavigationUi {
    static{
        MY_LISTS_BUTTON = "id:Saved";
    }
    public IOSNavigationUi(AppiumDriver driver) {
        super(driver);
    }
}
