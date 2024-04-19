package ui.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.yecht.Data;
import ui.pages.AuthorizationPage;
import ui.tests.BaseTest;

public class AuthorizationSteps {

    public AuthorizationPage authorizationPage = new AuthorizationPage(BaseTest.driver);

    @Step("Открываем страницу авторизации")
    public void openAuthorizationPage() {
        authorizationPage.goToAuthorizationPage();
        checkHeaderDisplayed(true);
    }

    @Step("Вводим логин")
    public void fillInLogin(String login) {
        authorizationPage.fillInLogin(login);
    }

    @Step("Вводим пароль")
    public void fillInPassword(String password) {
        authorizationPage.fillInPassword(password);
    }

    @Step("Нажимаем на кнопку входа")
    public void clickLoginButton() {
        authorizationPage.clickLoginButton();
    }



    @Step("Проверка, отображается ли заголовок")
    public void checkHeaderDisplayed(boolean expectedResult) {
        Assert.assertEquals(expectedResult, authorizationPage.headerIsDisplayed());
    }

    @Step("Ожидание пока окно с ошибкой авторизации будет отображаться")
    public void errorMessageShouldBeDisplayed() {
        authorizationPage.errorMessageShouldBeDisplayed();
    }

    @Step("Проверка текста в окне с ошибкой входа")
    public void checkTextErrorMessage(String text) {
        Assert.assertEquals(text, authorizationPage.getTextErrorMessage());
    }

    @Step("Нажимаем на кнокпу регистрации")
    public void clickRegistrationButton() {
        authorizationPage.clickRegistrationButton();
    }

    @Step("Вводим в поп-апе регистрации в поле логин текст: {login}")
    public void fillInLoginInRegistrationPopup(String login) {

    }

    @Step("Вводим в поп-апе регистрации в поле пароль текст: {password}")
    public void fillInPasswordInRegistrationPopup(String password) {

    }

    @Step("Вводим в поп-апе регистрации в поле email текст: {email}")
    public void fillInEmailInRegistrationPopup(String email) {

    }

    @Step("Нажимаем кнопку создать")
    public void clickCreateUserButton() {

    }

    @Step("Проверяем, что у поля логин в поп-апе регистрации красная обводка")
    public void checkThatRegistrationLoginInValid() {
        String expectedResult = "#dc3545";

    }

    @Step("Проверяем, что у поля пароль в поп-апе регистрации красная обводка")
    public void checkThatRegistrationPasswordInValid() {
        String expectedResult = "#dc3545";

    }

    @Step("Проверяем, что у поля email в поп-апе регистрации зеленая обводка")
    public void checkThatRegistrationEmailValid() {
        String expectedResult = "#198754";

    }

    @Step("Ждем пока поп-ап регистрации закроется")
    public void registrationPopupShouldNotBeDisplayed() {

    }


}
