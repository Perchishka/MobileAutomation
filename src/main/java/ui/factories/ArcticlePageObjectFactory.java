package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;
import ui.Mobile_Web.MwArticlePageObject;
import ui.android.AndroidArticlePageObject;
import ui.ios.IOSArticlePageObject;

public class ArcticlePageObjectFactory{

    public static ArticlePageObject get(RemoteWebDriver driver) {
        if (DevicePlatform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);}
        else if(DevicePlatform.getInstance().isMw()){
            return new MwArticlePageObject(driver); }
        else return new IOSArticlePageObject(driver);
    }
}
