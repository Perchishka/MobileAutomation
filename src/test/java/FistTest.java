import lib.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.ArticlePageObject;
import ui.MainPageObject;
import ui.SearchPageObject;
import ui.WikipediaMainPageObject;
import ui.factories.ArcticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class FistTest extends BaseTest {

    private MainPageObject mainPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    public void textBeforeSearch() {
        String searchResult = mainPageObject.waitForElementPrsenetBy(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Search field was not foud")
                .getAttribute("text");
        System.out.println(searchResult);
        Assert.assertTrue(searchResult.contains("Search"));
    }

    @Test
    public void testCanselSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.waitForCancelButtonToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelButtonToDisppear();
    }

    @Test
    public void testCompareArticle(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArcticlePageObjectFactory.get(driver)
       String article_title = articlePageObject.getArticleTitle();
       Assert.assertEquals("We see unexpected title",
               "Java (programming language)", article_title);
    }


    @Test
    public void testSearchWodaAndAfterCheckInvisibilitiOf3Elements() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        ArrayList<WebElement> list = new ArrayList<>();

        WebElement firstArticle = searchPageObject.waitForSearchResult("Object-oriented programming language");
        list.add(firstArticle);

        WebElement secondArticle = searchPageObject.waitForSearchResult("Island of Indonesia");
        list.add(secondArticle);

        WebElement thirdArticle =searchPageObject.waitForSearchResult("Programming language");
        list.add(thirdArticle);
        list.stream().forEach(i -> System.out.println(i.getAttribute("text")));

        SearchPageObject searchPageObject1 = SearchPageObjectFactory.get(driver);
        searchPageObject.clickBackButton();

        WikipediaMainPageObject wikipediaMainPageObject = new WikipediaMainPageObject(driver);
        wikipediaMainPageObject.waitForHeader();

        //Assert.assertTrue(waitForListOfWebElementsNotPresented(list));

        Assert.assertTrue(mainPageObject.waitForElementNotPresented(
                        ("xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                                "//*[@text='Object-oriented programming language']"),
                "Java element was not found", 15));
        Assert.assertTrue(mainPageObject.waitForElementNotPresented(
                        ("xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                                "//*[@text='Island of Indonesia']"),
                "Java element was not found", 15));
        Assert.assertTrue(mainPageObject.waitForElementNotPresented(
                        ("xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                                "//*[@text='Programming language']"),
                "Java element was not found", 15));


    }

    @Test
    public void testSearchForTheWord() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        List<WebElement> elements = searchPageObject.getListofArticlesByTitle();
        System.out.println(elements.size());

        elements.stream().allMatch(t -> t.getAttribute("text").contains("Java"));

    }

}
