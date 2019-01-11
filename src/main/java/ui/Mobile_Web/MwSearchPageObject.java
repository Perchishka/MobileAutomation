package ui.Mobile_Web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;

public class MwSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='Search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[@class='results']//li[@title='{SUBSTRING}']";
        SEARCH_RESULTS_LIST_ELEMENTS = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_RESULTS_LIST_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_BACK_BUTTON = "id:Back";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container' " +
                "and android.widget.LinearLayout[android.widget.TextView[contains(@text,'{TITLE}')] " +
                "and android.widget.TextView[contains(@text,'{DESCRIPTION}')] ]]";
        EMPTY_SEARCH = "css:p.without-results";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_ELEMENT="css:ul.page-list>li.page-summary";


    }

    public MwSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
