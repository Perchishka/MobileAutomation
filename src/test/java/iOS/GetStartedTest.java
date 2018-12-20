package iOS;

import lib.BaseTest;
import lib.DevicePlatform;
import org.junit.Test;
import ui.WelcomePageObject;

;

public class GetStartedTest extends BaseTest{

    @Test
    public void testPassThroughWelcome(){
        if (DevicePlatform.getInstance().isAndroid()){
            return;
        }
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

        welcomePageObject.waitForLearMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWayToExploreText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPreferredLangText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForLearnMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();
    }
}
