import lib.BaseTest;
import org.junit.Test;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;

public class Ex9Test extends BaseTest {

    @Test
    public void waitForElementByTitleAndDescription() {
        String title = "Java (programming language)";
        String description = "Object-oriented programming language";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitForElementByTitleAndDescription(title, description);

    }

    @Test
    public void testEx9() {

        String titleWebElement1 = "Java (programming language)";
        String descriptionWebElemnt1 = "Object-oriented programming language";
        String titleWebElement2 = "Java (software platform)";
        String descriptionWebElemnt2 = "Set of several computer software products and specifications";
        String titleWebElement3 = "Java";
        String descriptionWebElemnt3 ="Island of Indonesia";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitForElementByTitleAndDescription(titleWebElement1, descriptionWebElemnt1);
        searchPageObject.waitForElementByTitleAndDescription(titleWebElement2, descriptionWebElemnt2);
        searchPageObject.waitForElementByTitleAndDescription(titleWebElement3, descriptionWebElemnt3);




    }

}


