package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import ui.blocks.RegistrationBlock;
//import ui.blocks.RegistrationBlock;

import static data.Properties.BASE_URI;

public class AuthorizationPage {

//    private final String REGISTRATION_POPUP = "//div[@class='modal-content'][.//div[@id ='register-modal-title' and" +
//            " text() = 'Регистрация']]";

    private WebDriver driver;
    private String urlPage = BASE_URI + "login";

    private static RegistrationBlock registrationBlock;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
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

    public void fillInRegistrationLogin(String text) {
        registrationBlock.fillInRegistrationLogin(text);
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
