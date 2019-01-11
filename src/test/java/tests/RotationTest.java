package tests;

import lib.BaseTest;
import lib.DevicePlatform;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;
import ui.ArticlePageObject;
import ui.SearchPageObject;
import ui.factories.ArcticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

import java.time.Duration;

public class RotationTest extends BaseTest {

    @Test
    public void testChangeScreenOrientatitionSearchResult(){
        if(DevicePlatform.getInstance().isMw()){
            return;
        }
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Java (programming language)");
        ArticlePageObject  articlePageObject = ArcticlePageObjectFactory.get(driver);
        String articleBeforeRotation =articlePageObject.getArticleTitle();
        rotateScreenLandscape();
        String articleAfterRotation =articlePageObject.getArticleTitle();
        Assert.assertEquals("Article have been changed after screen rotation", articleAfterRotation, articleBeforeRotation);

    }

    @Test
    public void testCheckSearchArticleInBackGround(){
        if(DevicePlatform.getInstance().isMw()){
            return;
        }
        SearchPageObject searchPageObject =SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        backgroundApp(2);
    }
}
