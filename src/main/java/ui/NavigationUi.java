package ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUi extends MainPageObject {

  protected static String
            MY_LISTS_BUTTON;

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
