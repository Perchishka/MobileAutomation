import org.junit.Assert;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.SearchPageObject;

public class Ex6AndEx7 extends BaseTest {

    @Test
    public void testAssertionFirst() {

        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        int amount_ofSearch_Result = searchPageObject.getAmountOfElements();
        Assert.assertTrue("We found too few results", amount_ofSearch_Result>0);
    }

    @Test
    public void testAssertionAmountOfEmptySeaarch() {
        String searchLine ="java";
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultLable();

        searchPageObject.assertElementNotPresent("We've found some results by request "+searchLine);

    }

    @Test
    public void testEx6() {
        String searchLine ="Java";
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring("Java");

        ArticlePageObject articlePageObject = new ArticlePageObject(driver);

        articlePageObject.assertElementPresent("We've not found article title "+searchLine);


    }
}
