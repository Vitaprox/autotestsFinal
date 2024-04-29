package ui.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ui.pages.AuthorizationPage;
import ui.tests.BaseTest;

public class AuthorizationSteps {

    private AuthorizationPage authorizationPage = new AuthorizationPage(BaseTest.driver.get());

    @Step("Открываем страницу авторизации")
    public void openAuthorizationPage() {
        authorizationPage.goToAuthorizationPage();
    }

    @Step("Вводим логин {login}")
    public void fillInLogin(String login) {
        authorizationPage.fillInLogin(login);
    }

    @Step("Вводим пароль {password}")
    public void fillInPassword(String password) {
        authorizationPage.fillInPassword(password);
    }

    @Step("Нажимаем на кнопку входа")
    public void clickLoginButton() {
        authorizationPage.clickLoginButton();
    }

    @Step("Проверка, отображается ли заголовок. Ожидаемый результат: {expectedResult}")
    public void checkHeaderDisplayed(boolean expectedResult) {
        Assert.assertEquals(expectedResult, authorizationPage.headerIsDisplayed());
    }

    @Step("Ожидание пока окно с ошибкой авторизации будет отображаться")
    public void errorMessageShouldBeDisplayed() {
        authorizationPage.errorMessageShouldBeDisplayed();
    }

    @Step("Проверка, что в окне с ошибкой входа текст: {text}")
    public void checkTextErrorMessage(String text) {
        Assert.assertEquals(text, authorizationPage.getTextErrorMessage());
    }

    @Step("Нажимаем на кнопку регистрации")
    public void clickRegistrationButton() {
        authorizationPage.clickRegistrationButton();
    }


    @Step("Вводим в поп-апе регистрации в поле логин текст: {login}")
    public void fillInLoginInRegistrationPopup(String login) {
        authorizationPage.fillInRegistrationLogin(login);
    }

    @Step("Вводим в поп-апе регистрации в поле пароль текст: {password}")
    public void fillInPasswordInRegistrationPopup(String password) {
        authorizationPage.fillInRegistrationPassword(password);
    }

    @Step("Вводим в поп-апе регистрации в поле email текст: {email}")
    public void fillInEmailInRegistrationPopup(String email) {
        authorizationPage.fillInRegistrationEmail(email);
    }

    @Step("Нажимаем кнопку создать")
    public void clickCreateUserButton() {
        authorizationPage.clickRegistrationCreateButton();
    }

    private String getBorderColor(String correctOrIncorrect) {
        String color;
        if (correctOrIncorrect.equals("correct")) {
            color = "rgb(25, 135, 84)";
        } else {
            color = "rgb(220, 53, 69)";
        }
        return color;
    }

    @Step("Проверяем обводку поля Логин в попапе регистрации")
    public void checkRegistrationLoginFieldColor(String correctOrIncorrect) {
        String expectedColor = getBorderColor(correctOrIncorrect);
        String actualColor = authorizationPage.getLoginFieldBorderColor();
        Assert.assertEquals(expectedColor, actualColor);
    }

    @Step("Ждем, пока обводка поля логин в поп-апе регистрации перестанет быть стандартного цвета")
    public void loginBorderColorShouldNotBeStandard() {
        authorizationPage.loginBorderColorShouldNotBeStandard();
    }

    @Step("Проверяем обводку поля Пароль в попапе регистрации")
    public void checkRegistrationPasswordFieldColor(String correctOrIncorrect) {
        String expectedColor = getBorderColor(correctOrIncorrect);
        String actualColor = authorizationPage.getPasswordFieldBorderColor();
        Assert.assertEquals(expectedColor, actualColor);
    }

    @Step("Проверяем, что у поля email в поп-апе регистрации зеленая обводка")
    public void checkThatRegistrationEmailFieldCorrect() {
        String expectedColor = "rgb(25, 135, 84)";
        String actualColor = authorizationPage.getEmailFieldBorderColor();
        Assert.assertEquals(expectedColor, actualColor);
    }

    @Step("Ждем пока поп-ап регистрации закроется")
    public void registrationPopupShouldNotBeVisible() {
        authorizationPage.registrationPopupShouldNotBeVisible();
    }


}
