package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.DevicePlatform;
import ui.ArticlePageObject;
import ui.android.AndroidArticlePageObject;
import ui.ios.IOSArticlePageObject;

public class ArcticlePageObjectFactory{

    public static ArticlePageObject get(AppiumDriver driver) {
        if (DevicePlatform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }else return new IOSArticlePageObject(driver);
    }
}
