package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import ui.MyListsPageObject;
import ui.android.AbdroidMyListPageObject;
import ui.ios.IOSMyListPageObject;

public class MyListPageObjectFactory {

    public MyListsPageObject get(AppiumDriver driver){
        if(DevicePlatform.getInstance().isAndroid()){
            return new AbdroidMyListPageObject(driver);
        }
        else {
            return new IOSMyListPageObject(driver);
        }
    }
}
