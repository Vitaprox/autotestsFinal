package ui.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
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


}
