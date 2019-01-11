package ui.Mobile_Web;

import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUi;

public class MwNavigationUi extends NavigationUi {
    static{
        MY_LISTS_BUTTON = "css:a[data-event-name='watchlist']";
        OPEN_NAVIGATION="css:#mw-mf-main-menu-button";
    }
    public MwNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }



}
