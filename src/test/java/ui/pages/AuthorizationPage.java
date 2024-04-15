package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    private final String REGISTRATION_POPUP = "//div[@class='modal-content'][.//div[@id ='register-modal-title' and" +
            " text() = 'Регистрация']]";

    private WebDriver driver;
    private String urlPage = "http://172.24.120.5:8081/login";

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-input")
    private WebElement loginTextField;

    @FindBy(id = "password-input")
    private WebElement passwordTextField;

    @FindBy(id = "form_auth_button")
    private WebElement loginButton;

    @FindBy(id = "form_register_button")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[@role='alert']//div[text()]")
    private WebElement errorMessage;

    @FindBy(className = "form_auth_block_head_text")
    private WebElement header;

    @FindBy(xpath = REGISTRATION_POPUP)
    private WebElement registrationPopup;

    @FindBy(xpath = REGISTRATION_POPUP + "//input[@placeholder='Логин']")
    private WebElement registrationLoginInput;

    @FindBy(xpath = REGISTRATION_POPUP + "//input[@placeholder='Пароль']")
    private WebElement registrationPasswordInput;

    @FindBy(xpath = REGISTRATION_POPUP + "//label[text()='E-mail']/following::input")
    private WebElement registrationEmailInput;

    public void fillInRegistrationLogin(String text) {
        registrationLoginInput.sendKeys(text);
    }

    public void fillInRegistrationPassword(String text) {
        registrationPasswordInput.sendKeys(text);
    }

    public void fillInRegistrationEmail(String text) {
        registrationEmailInput.sendKeys(text);
    }

    public boolean registrationPopupIsDisplayed() {
        return registrationPopup.isDisplayed();
    }



    public boolean headerIsDisplayed() {
        return header.isDisplayed();
    }

    public boolean errorMessageIdDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String getTextErrorMessage() {
        return errorMessage.getText();
    }

    public boolean registrationButtonIsDisplayed() {
        return registrationButton.isDisplayed();
    }

    public void clickRegistrationButton() {
        registrationButton.click();
    }
    public void goToAuthorizationPage() {
        driver.get(urlPage);
    }

    public void fillInLogin(String loginText) {
        loginTextField.sendKeys(loginText);
    }

    public void fillInPassword(String passwordText) {
        passwordTextField.sendKeys(passwordText);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean loginButtonIsDisplayed() {
        return loginButton.isDisplayed();
    }
}
