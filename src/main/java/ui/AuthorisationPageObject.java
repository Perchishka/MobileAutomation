package ui;

import Test1.MainClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorisationPageObject extends MainPageObject{
    public AuthorisationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
public final static String
        LOGIN_BUTTON="xpath://div/a[contains(text(), 'Log in')]",
        LOGIN_INPUT="css:input[name='wpName']",
        PASSWORD_INPUT="css:input[name='wpPassword']",
        SUBMIT_BUTTON="css:button#wpLoginAttempt";

public void clickAuthButton(){
    waitForElementAndClick(LOGIN_BUTTON, "cannot find auth button", 5);
}

public void enterLoginData(String login, String password) throws InterruptedException {
    waitForElementClearAndSendkeys(LOGIN_INPUT, "cannot find login input", login, 5);
    waitForElementClearAndSendkeys(PASSWORD_INPUT, "cannot find password input", password, 5);


    }


public void clickSubmitButton(){
    waitForElementAndClick(SUBMIT_BUTTON, "cannot find submit button", 5);
}

}
