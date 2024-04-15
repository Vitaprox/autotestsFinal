package ui.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.AuthorizationPage;
import ui.tests.BaseTest;

public class AuthorizationSteps {

    public AuthorizationPage authorizationPage = new AuthorizationPage(BaseTest.driver);

    public void openAuthorizationPage() {
        authorizationPage.goToAuthorizationPage();
        checkHeaderDisplayed(true);
    }

    public void fillInLogin(String login) {
        authorizationPage.fillInLogin(login);
    }

    public void fillInPassword(String password) {
        authorizationPage.fillInPassword(password);
    }

    public void clickLoginButton() {
        authorizationPage.clickLoginButton();
    }



    public void checkHeaderDisplayed(boolean expectedResult) {
        Assert.assertEquals(expectedResult, authorizationPage.headerIsDisplayed());
    }


}
