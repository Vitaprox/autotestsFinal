package ui.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = "//div[@class='modal-content'][.//div[@id ='register-modal-title' and text() = 'Регистрация']]")
public class RegistrationBlock extends HtmlElement {


    @FindBy(xpath = ".//input[@placeholder='Логин']")
    private WebElement registrationLoginInput;

    @FindBy(xpath = ".//input[@placeholder='Пароль']")
    private WebElement registrationPasswordInput;

    @FindBy(xpath = ".//label[text()='E-mail']/following::input")
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
}
