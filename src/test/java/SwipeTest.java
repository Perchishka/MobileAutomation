import lib.BaseTest;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.MainPageObject;
import ui.SearchPageObject;
import ui.factories.ArcticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

public class SwipeTest extends BaseTest {
    private MainPageObject mainPageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    public void swipeUpTest() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject articlePageObject = ArcticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();

        mainPageObject.swipeUp(1000);

    }

    @Test
    public void swipeTillElementTest() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Appium");
        searchPageObject.clickByArticleWithSubstring("Appium");
        ArticlePageObject articlePageObject = ArcticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        articlePageObject.swipeToFooter();
    }

}
