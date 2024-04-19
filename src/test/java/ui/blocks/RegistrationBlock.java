package ui.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
//import org.openqa.selenium.internal.WrapsElement;


//@FindBy(xpath = "//div[@class='modal-content'][.//div[@id ='register-modal-title' and text() = 'Регистрация']]")
//public class RegistrationBlock extends HtmlElement {
//
//
//    @FindBy(xpath = ".//input[@placeholder='Логин']")
//    private WebElement registrationLoginField;
//
//    @FindBy(xpath = ".//input[@placeholder='Пароль']")
//    private WebElement registrationPasswordField;
//
//    @FindBy(xpath = ".//label[text()='E-mail']/following::input")
//    private WebElement registrationEmailField;
//
//    @FindBy(xpath = ".//button[@type='submit']")
//    private WebElement registrationCreateButton;
//
//    public void fillInRegistrationLogin(String text) {
//        registrationLoginField.sendKeys(text);
//    }
//
//    public void fillInRegistrationPassword(String text) {
//        registrationPasswordField.sendKeys(text);
//    }
//
//    public void fillInRegistrationEmail(String text) {
//        registrationEmailField.sendKeys(text);
//    }
//
//    public void clickRegistrationCreateButton() {
//        registrationCreateButton.click();
//    }
//
//    public void getLoginFieldBorderColor() {
//        registrationLoginField.getCssValue("border-color");
//    }
//
//    public void getPasswordFieldBorderColor() {
//        registrationPasswordField.getCssValue("border-color");
//    }
//
//    public void getEmailFieldBorderColor() {
//        registrationEmailField.getCssValue("border-color");
//    }
//}
