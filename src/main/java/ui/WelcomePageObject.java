package ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {
    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
    STEP_LEARN_MORE_LINK="id:Learn more about Wikipedia",
    STEP_NEY_WAYS_TO_EXPLORE="id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK="id:Add or edit preferred languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK="id:Learn more about data collected",
    NEXT_BUTTON="id:Next",
    GET_STARTED_BUTTON="id:Get started";



    public void waitForLearMoreLink(){
        this.waitForElementPrsenetBy(STEP_LEARN_MORE_LINK, "cannot find 'Learn more about Wikipedia' link", 15);
    }

    public void waitForNewWayToExploreText(){
        this.waitForElementPrsenetBy(STEP_NEY_WAYS_TO_EXPLORE, "cannot find 'New ways to explore' text", 15);
    }
    public void waitForAddOrEditPreferredLangText(){
        this.waitForElementPrsenetBy(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Add or edit preferred languages' text", 15);
    }

    public void waitForLearnMoreAboutDataCollectedText(){
        this.waitForElementPrsenetBy(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Learn more about data collected' link", 15);
    }


    public void clickNextButton(){
        this.waitForElementAndClick(NEXT_BUTTON, "cannot find and clock 'Next' button", 15);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(GET_STARTED_BUTTON, "cannot find and clock 'Get started' button", 15);
    }
}
