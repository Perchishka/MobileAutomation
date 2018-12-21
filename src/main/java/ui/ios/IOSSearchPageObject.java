package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSearchField";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        SEARCH_RESULTS_LIST_ELEMENTS = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_RESULTS_LIST_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_BACK_BUTTON = "id:Back";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container' " +
                "and android.widget.LinearLayout[android.widget.TextView[contains(@text,'{TITLE}')] " +
                "and android.widget.TextView[contains(@text,'{DESCRIPTION}')] ]]";
        EMPTY_SEARCH = "xpath://*[@text='No results found']";
        SEARCH_CANCEL_BUTTON = "id:Close";


    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
