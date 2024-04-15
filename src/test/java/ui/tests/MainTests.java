package ui.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MainTests extends BaseTest{

    @Test
    public void DBTest() {

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin("Dtest");
        authorizationSteps.fillInPassword("Dtest");
        authorizationSteps.clickLoginButton();
//    authorizationPage.goToAuthorizationPage();
//    authorizationPage.fillInLogin("Dtest");
//    authorizationPage.fillInPassword("Dtest");
//    authorizationPage.clickLoginButton();

    Assert.assertTrue("Заметка не отображается", mainPage.notesIsDisplayed());
    }

}
