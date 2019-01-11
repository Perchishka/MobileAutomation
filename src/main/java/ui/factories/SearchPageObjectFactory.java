package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.Mobile_Web.MwSearchPageObject;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.ios.IOSSearchPageObject;

public class SearchPageObjectFactory {

    public static SearchPageObject get(RemoteWebDriver driver){
        if(DevicePlatform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        }else if(DevicePlatform.getInstance().isIOS()){
            return  new IOSSearchPageObject(driver);
        } else {
            return new MwSearchPageObject(driver);
        }
    }
}
