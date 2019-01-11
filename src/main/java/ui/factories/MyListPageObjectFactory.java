package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.Mobile_Web.MwMyListsPageObject;
import ui.MyListsPageObject;
import ui.android.AbdroidMyListPageObject;
import ui.ios.IOSMyListPageObject;

public class MyListPageObjectFactory {

    public MyListsPageObject get(RemoteWebDriver driver){
        if(DevicePlatform.getInstance().isAndroid()){
            return new AbdroidMyListPageObject(driver);
        } else if(DevicePlatform.getInstance().isMw()){
            return new MwMyListsPageObject(driver);
        }
        else {
            return new IOSMyListPageObject(driver);
        }
    }
}
