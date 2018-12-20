package ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUi extends MainPageObject {

    private static final String
            MY_LISTS_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUi(AppiumDriver driver) {
        super(driver);
    }


    public void clickOnMyListsButton() {
        this.waitForElementAndClick(MY_LISTS_BUTTON,
                "Cannot find first button to navigate to MyLists", 15);
    }


    /*TEMPLATES METHODS*/



    /*TEMPLATES METHODS*/
}
