import lib.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;
import ui.ArticlePageObject;
import ui.SearchPageObject;

import java.time.Duration;

public class RotationTest extends BaseTest {

    @Test
    public void testChangeScreenOrientatitionSearchResult(){
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Java (programming language)");
        ArticlePageObject  articlePageObject = new ArticlePageObject(driver);
        String articleBeforeRotation =articlePageObject.getArticleTitle();
        driver.rotate(ScreenOrientation.LANDSCAPE);
        String articleAfterRotation =articlePageObject.getArticleTitle();
        Assert.assertEquals("Article have been changed after screen rotation", articleAfterRotation, articleBeforeRotation);

    }

    @Test
    public void testCheckSearchArticleInBackGround(){

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        driver.runAppInBackground(Duration.ofSeconds(2));
    }
}
