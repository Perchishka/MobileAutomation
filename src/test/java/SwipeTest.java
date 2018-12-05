import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.ArticlePageObject;
import ui.MainPageObject;
import ui.SearchPageObject;

public class SwipeTest extends BaseTest {
    private MainPageObject mainPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    public void swipeUpTest() {

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitForTitleElement();

        mainPageObject.swipeUp(2000);

    }

    @Test
    public void swipeTillElementTest() {

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Appium");
        searchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        articlePageObject.waitForTitleElement();
        articlePageObject.swipeToFooter();
    }

}
