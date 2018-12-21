import lib.BaseTest;
import lib.DevicePlatform;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.*;
import ui.factories.ArcticlePageObjectFactory;
import ui.factories.NavigationUiFactory;
import ui.factories.SearchPageObjectFactory;

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
        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        MyListsPageObject myListsPAgeObject = new MyListsPageObject(driver);

        ArrayList<String> arcticlesNames = new ArrayList<String>() {{
            add(firstArticle);
            add(secondrticle);
        }};
        for (String i : arcticlesNames) {
            SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
            searchPageObject.initSearchInput();
            searchPageObject.typeSearchLine("Java");
            searchPageObject.clickByArticleWithSubstring(i);
            ArticlePageObject articlePageObject = ArcticlePageObjectFactory.get(driver);

            String article_title = articlePageObject.getArticleTitle();
            System.out.println(article_title);
            if (DevicePlatform.getInstance().isAndroid()) {
                articlePageObject.clickOnAddToMyListButton();

                if (j < 1) {
                    articlePageObject.addArticleToMyListIfFolderDoesntExist(folderName);
                    articlePageObject.closeArticle();
                    j++;
                } else {
                    myListsPAgeObject.clickOnExistingFolder(folderName);
                    articlePageObject.closeArticle();
                }
                navigationUi.clickOnMyListsButton();
                myListsPAgeObject.clickOnExistingFolder(folderName);
                myListsPAgeObject.swipeByArticleToDelete(firstArticle);


            } else {
                articlePageObject.addArticleToMySavedIos();
                navigationUi.clickOnMyListsButton();
                myListsPAgeObject.swipeByArticleToDelete(firstArticle);
            }

            myListsPAgeObject.waitForArticleToAapearByTitle(secondrticle);
            WebElement element = mainPageObject.waitForElementPrsenetBy(By.xpath("//*[@text='Java']"),
                    "needed article was not found", 15);
        }

    }
}
