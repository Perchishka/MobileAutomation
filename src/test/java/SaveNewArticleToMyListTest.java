import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaveNewArticleToMyListTest extends BaseTest {


    @Test
    public void testSaveNewArticleToMyListTest() {


        String folderName = "Learning programming";
        String firstArticle = "Object-oriented programming language";
        String secondrticle = "Java";
        int j = 0;

        ArrayList<String> arcticlesNames = new ArrayList<String>() {{
            add(firstArticle);
            add(secondrticle);
        }};
        for (String i : arcticlesNames) {
            waitForElementAndClick(By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                    "Cannot find Search input", 15);

            waitForElementAndSendkeys(By.xpath("//*[contains(@text, 'Search…')]"),
                    "Cannot find search input", "Java", 15);

            waitForElementAndClick(
                    By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                            "//*[@text='" + i + "']"),
                    "Java element was not found", 15);
            waitForElementPrsenetBy(
                    By.id("org.wikipedia:id/view_page_title_text"),
                    "Page Title was not found", 15);

            waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                    "Cannot find first button to open article options", 15);

            waitForElementAndClick(By.xpath("//*[@text='Add to reading list']"),
                    "Element from DropdownList didnt find", 15);


            if (j < 1) {
                waitForElementAndClick(
                        By.id("org.wikipedia:id/onboarding_button"),
                        "Java element was not found", 15);

                waitForElementClearAndSendkeys(By.id("org.wikipedia:id/text_input"),
                        "Cannot find text field for set name",
                        folderName, 15);

                waitForElementAndClick(By.xpath("//*[@text='OK']"),
                        "Cannot find ok button", 20);

                waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                        "Cannot find first button to close article", 15);
                j++;
            } else {
                waitForElementAndClick(
                        By.xpath("//*[@text='" + folderName + "']"),
                        "Java element was not found", 20);

                waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                        "Cannot find first button to close article", 15);
            }

        }

        waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find first button to navigate to MyLists", 15);

        waitForElementAndClick(By.xpath("//*[@text='" + folderName + "']"),
                "Cannot find created folder", 15);

        swipeElementToLeft(By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article");

        waitForElementNotPresented(By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article", 15);

        WebElement element = waitForElementPrsenetBy(By.xpath("//*[@text='Java']"),
                "needed article was not found", 15);
        Assert.assertNotNull(element);
    }

}
