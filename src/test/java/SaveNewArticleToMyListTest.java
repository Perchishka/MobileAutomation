import lib.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.*;

import java.util.ArrayList;

public class SaveNewArticleToMyListTest extends BaseTest {
    private MainPageObject mainPageObject;

    public void setUp() throws Exception {
        super.setUp();
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSaveNewArticleToMyListTest() {


        String folderName = "Learning programming";
        String firstArticle = "Java (programming language)";
        String secondrticle = "Java";
        int j = 0;
        NavigationUi navigationUi = new NavigationUi(driver);
        MyListsPAgeObject myListsPAgeObject = new MyListsPAgeObject(driver);

        ArrayList<String> arcticlesNames = new ArrayList<String>() {{
            add(firstArticle);
            add(secondrticle);
        }};
        for (String i : arcticlesNames) {
            SearchPageObject searchPageObject = new SearchPageObject(driver);
            searchPageObject.initSearchInput();
            searchPageObject.typeSearchLine("Java");
            searchPageObject.clickByArticleWithSubstring(i);
            ArticlePageObject articlePageObject = new ArticlePageObject(driver);
            String article_title = articlePageObject.getArticleTitle();
            System.out.println(article_title);
            articlePageObject.clickOnAddToMyListButton();

            if (j < 1) {
                articlePageObject.addArticleToMyListIfFolderDoesntExist(folderName);
                articlePageObject.closeArticle();
                j++;
            } else {
                myListsPAgeObject.clickOnExistingFolder(folderName);
                articlePageObject.closeArticle();
            }

        }


        navigationUi.clickOnMyListsButton();
        myListsPAgeObject.clickOnExistingFolder(folderName);
        myListsPAgeObject.swipeByArticleToDelete(firstArticle);
        myListsPAgeObject.waitForArticleToAapearByTitle(secondrticle);

        WebElement element = mainPageObject.waitForElementPrsenetBy(By.xpath("//*[@text='Java']"),
                "needed article was not found", 15);
        Assert.assertNotNull(element);
    }

}
