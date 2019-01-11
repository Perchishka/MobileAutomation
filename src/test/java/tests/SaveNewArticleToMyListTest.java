package tests;

import lib.BaseTest;
import lib.DevicePlatform;
import org.junit.Test;
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
    public void testSaveNewArticleToMyListTest() throws InterruptedException {


        String folderName = "Learning programming";
        String firstArticle = "Java (programming language)";
        String secondrticle = "Java";
        String password = "Musya2010";
        String login = "doggys111";
        int j = 0;
        NavigationUi navigationUi = NavigationUiFactory.get(driver);
        MyListsPageObject myListsPAgeObject = new MyListsPageObject(driver);

        ArrayList<String> arcticlesNames = new ArrayList<String>() {{
            add(firstArticle);
            add(secondrticle);
        }};

            SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
            searchPageObject.initSearchInput();
            searchPageObject.typeSearchLine("Java");
        for (String i : arcticlesNames) {
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
                }}

            else if(DevicePlatform.getInstance().isMw()){
                    articlePageObject.addArticleToMySavedIos();
                    AuthorisationPageObject auth = new AuthorisationPageObject(driver);
                    auth.clickAuthButton();
                    auth.enterLoginData(login, password);

                    auth.clickSubmitButton();



                    articlePageObject.waitForTitleElement();
                    assertEquals("we are not on the same page after login",
                            article_title, articlePageObject.getArticleTitle());

                    navigationUi.openNavigation();


                }

            else if (DevicePlatform.getInstance().isIOS()){
                if(j<1) {
                    articlePageObject.addArticleToMySavedIos();
                    articlePageObject.closeAuthWindow();
                    articlePageObject.closeArticle();

                    searchPageObject.clickSearchLine();
                    j++;
                }else{
                    articlePageObject.addArticleToMySavedIos();
                    articlePageObject.closeArticle();
                }

            }

        }
        if(DevicePlatform.getInstance().isAndroid()){
            navigationUi.clickOnMyListsButton();
            myListsPAgeObject.clickOnExistingFolder(folderName);
            myListsPAgeObject.swipeByArticleToDelete(firstArticle);

        }else{
            navigationUi.clickOnMyListsButton();
            myListsPAgeObject.swipeByArticleToDelete(firstArticle);
        }
        myListsPAgeObject.waitForArticleToAapearByTitle(secondrticle);
        //WebElement element = mainPageObject.waitForElementPrsenetBy(By.xpath("//*[@text='Java']"),
        //      "needed article was not found", 15);
    }
}
