package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.Properties.STANDARD_PASSWORD;

@DisplayName("Проверка Регистрации UI")
public class RegistrationTests extends BaseTest{

    @Test
    @DisplayName(value = "Проверка успешной регистрации со всеми полями")
    public void checkRegistrationWithAllFields() {
        commonSteps.saveValueInMap("login", "DtestUser10");
        commonSteps.saveValueInMap("email", "DtestUser10@mail.ru");
        dbSteps.deleteUserIfItExist(commonSteps.getValueFromValueMap("login"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickRegistrationButton();
        authorizationSteps.fillInLoginInRegistrationPopup(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPasswordInRegistrationPopup(STANDARD_PASSWORD);
        authorizationSteps.fillInEmailInRegistrationPopup(commonSteps.getValueFromValueMap("email"));
        authorizationSteps.clickCreateUserButton();
        authorizationSteps.registrationPopupShouldNotBeVisible();

        dbSteps.checkUsersCount(1, commonSteps.getValueFromValueMap("login"));
        dbSteps.checkUserEmail(commonSteps.getValueFromValueMap("login"), commonSteps.getValueFromValueMap("email"));
        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка успешной регистрации с обязательными полями")
    public void checkRegistrationWithRequiredFields() {
        commonSteps.saveValueInMap("login", "DtestUser10");
        dbSteps.deleteUserIfItExist(commonSteps.getValueFromValueMap("login"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickRegistrationButton();
        authorizationSteps.fillInLoginInRegistrationPopup(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPasswordInRegistrationPopup(STANDARD_PASSWORD);
        authorizationSteps.clickCreateUserButton();
        authorizationSteps.registrationPopupShouldNotBeVisible();

        dbSteps.checkUsersCount(1, commonSteps.getValueFromValueMap("login"));
        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка регистрации если логин уже занят")
    public void checkRegistrationWithBusyLogin() {
        commonSteps.saveValueInMap("login", "DtestUser10");
        commonSteps.saveValueInMap("email", "email1@mail.ru");
        commonSteps.saveValueInMap("email2", "email2@mail.ru");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"), commonSteps.getValueFromValueMap("email"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickRegistrationButton();
        authorizationSteps.fillInLoginInRegistrationPopup(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPasswordInRegistrationPopup(STANDARD_PASSWORD);
        authorizationSteps.fillInEmailInRegistrationPopup(commonSteps.getValueFromValueMap("email2"));
        authorizationSteps.clickCreateUserButton();
        authorizationSteps.registrationPopupShouldNotBeVisible();

        dbSteps.checkUsersCount(1, commonSteps.getValueFromValueMap("login"));
        dbSteps.checkUserEmail(commonSteps.getValueFromValueMap("login"), commonSteps.getValueFromValueMap("email"));
        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка регистрации без заполненных полей")
    public void checkRegistrationWithoutField() {
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickRegistrationButton();
        authorizationSteps.clickCreateUserButton();
        authorizationSteps.loginBorderColorShouldNotBeStandard();
        authorizationSteps.checkRegistrationLoginFieldColor("incorrect");
        authorizationSteps.checkRegistrationPasswordFieldColor("incorrect");
        authorizationSteps.checkThatRegistrationEmailFieldCorrect();
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с логином")
    public void checkRegistrationWithLogin() {
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickRegistrationButton();
        authorizationSteps.fillInLoginInRegistrationPopup("text");
        authorizationSteps.clickCreateUserButton();
        authorizationSteps.loginBorderColorShouldNotBeStandard();
        authorizationSteps.checkRegistrationLoginFieldColor("correct");
        authorizationSteps.checkRegistrationPasswordFieldColor("incorrect");
        authorizationSteps.checkThatRegistrationEmailFieldCorrect();
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с паролем")
    public void checkRegistrationWithPassword() {
        authorizationSteps.openAuthorizationPage();
        authorizationSteps.clickRegistrationButton();
        authorizationSteps.fillInPasswordInRegistrationPopup("text");
        authorizationSteps.clickCreateUserButton();
        authorizationSteps.loginBorderColorShouldNotBeStandard();
        authorizationSteps.checkRegistrationLoginFieldColor("incorrect");
        authorizationSteps.checkRegistrationPasswordFieldColor("correct");
        authorizationSteps.checkThatRegistrationEmailFieldCorrect();
    }

}
