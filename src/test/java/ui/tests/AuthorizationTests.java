package ui.tests;

import io.qameta.allure.Description;
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
    @Description("Проверка успешной авторизации")
    public void checkValidAuthorization() {
        commonSteps.saveValueInMap("login", "DtestUser");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @Description("Проверка авторизации с несуществующим логином")
    public void checkAuthorizationWithInvalidLogin() {
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin("DtestFakeLogin");
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.checkTextErrorMessage("Ошибка авторизации");
    }

    @Test
    @Description("Проверка авторизации с неправильным паролем")
    public void checkAuthorizationWithInvalidPassword() {
        commonSteps.saveValueInMap("login", "DtestUser");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword("512412512");
        authorizationSteps.clickLoginButton();
        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.checkTextErrorMessage("Ошибка авторизации");
        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @Description("Проверка авторизации без логина и пароля")
    public void checkAuthorizationWithoutLoginAndPassword() {
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickLoginButton();
        authorizationSteps.errorMessageShouldBeDisplayed();
        authorizationSteps.checkTextErrorMessage("Ошибка авторизации");
    }
}
