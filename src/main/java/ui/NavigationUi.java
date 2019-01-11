package ui;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUi extends MainPageObject {

  protected static String
            MY_LISTS_BUTTON,
            OPEN_NAVIGATION;

    public NavigationUi(RemoteWebDriver driver) {
        super(driver);
    }


    public void clickOnMyListsButton() {
        if(DevicePlatform.getInstance().isMw()){
            tryClickElementWithFewAttempts(MY_LISTS_BUTTON,
                    "Cannot find first button to navigate to MyLists", 5);
        }
        this.waitForElementAndClick(MY_LISTS_BUTTON,
                "Cannot find first button to navigate to MyLists", 15);
    }

    public void openNavigation() {
        if (DevicePlatform.getInstance().isMw()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "cannot menu button", 5);
        }
    }


    /*TEMPLATES METHODS*/



    /*TEMPLATES METHODS*/
}
