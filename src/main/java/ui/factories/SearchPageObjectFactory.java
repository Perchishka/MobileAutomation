package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.ios.IOSSearchPageObject;

public class SearchPageObjectFactory {

    public static SearchPageObject get(AppiumDriver driver){
        if(DevicePlatform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        }else {
            return  new IOSSearchPageObject(driver);
        }
    }
}
