import lib.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.SearchPageObject;
import ui.factories.ArcticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

public class Ex6AndEx7 extends BaseTest {
    SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
    ArticlePageObject articlePageObject = ArcticlePageObjectFactory.get(driver);


    @Test
    public void testAssertionFirst() {
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        int amount_ofSearch_Result = searchPageObject.getAmountOfElements();
        Assert.assertTrue("We found too few results", amount_ofSearch_Result > 0);
    }

    @Test
    public void testAssertionAmountOfEmptySeaarch() {
        String searchLine = "java";
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultLable();
        searchPageObject.assertElementNotPresent("We've found some results by request " + searchLine);

    }

    @Test
    public void testEx6() {
        String searchLine = "Java";
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring("Java");
        articlePageObject.assertElementPresent("We've not found article title " + searchLine);


    }
}
