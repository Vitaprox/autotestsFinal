package ui.tests;

import org.junit.jupiter.api.Test;

import static data.Properties.STANDARD_PASSWORD;

public class AuthorizationTests extends BaseTest{

//    @Test
//    public void authorizationWithValidLoginAndPassword() {
//        authorizationSteps.openAuthorizationPage();
//        authorizationSteps.fillInLogin("Dtest");
//        authorizationSteps.fillInPassword("Dtest");
//        authorizationSteps.clickLoginButton();
//    }

    @Test
    public void checkValidAuthorization() {
        commonSteps.saveValueInMap("login", "DtestUser01");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    public void checkAuthorizationWithInvalidLogin() {
        commonSteps.saveValueInMap("login", "DtestFakeLogin");
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
    }
}
