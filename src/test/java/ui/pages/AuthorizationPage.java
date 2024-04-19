package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.Properties.BASE_URI;

public class AuthorizationPage {

//    private final String REGISTRATION_POPUP = "//div[@class='modal-content'][.//div[@id ='register-modal-title' and" +
//            " text() = 'Регистрация']]";

    private WebDriver driver;
    private String urlPage = BASE_URI + "login";
    private WebDriverWait wait;

//    private static RegistrationBlock registrationBlock;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
//        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
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


    public boolean headerIsDisplayed() {
        return header.isDisplayed();
    }

    public void errorMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(errorMessage));
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
