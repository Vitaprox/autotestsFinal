package ui.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.AuthorizationPage;
import ui.tests.BaseTest;

public class AuthorizationSteps {

    private AuthorizationPage authorizationPage = new AuthorizationPage(BaseTest.driver);

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


    @Step("Проверяем, что заголовок отображается")
    public void checkHeaderDisplayed(boolean expectedResult) {
        Assert.assertEquals(expectedResult, authorizationPage.headerIsDisplayed());
    }

    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        authorizationPage.clickRegistrationButton();
    }

    @Step("Вводим текст в поле логина в поп-апе регистрации")
    public void fillInRegistrationLogin(String text) {
        authorizationPage.fillInRegistrationLogin(text);
    }


}
