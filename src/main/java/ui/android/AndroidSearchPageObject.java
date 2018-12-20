package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                "//*[@text='{SUBSTRING}']";
        SEARCH_RESULTS_LIST_ELEMENTS = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_RESULTS_LIST_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']" +
                "//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_BACK_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_toolbar']" +
                "//*[@class='android.widget.ImageButton']";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container' " +
                "and android.widget.LinearLayout[android.widget.TextView[contains(@text,'{TITLE}')] " +
                "and android.widget.TextView[contains(@text,'{DESCRIPTION}')] ]]";
        EMPTY_SEARCH = "xpath://*[@text='No results found']";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }

}
