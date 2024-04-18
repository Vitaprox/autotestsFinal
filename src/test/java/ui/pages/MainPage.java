package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yecht.Data;

import java.util.List;

import static data.Properties.BASE_URI;

public class MainPage {

    private WebDriver driver;

    private final String NOTE_XPATH = "//div[contains(@id, 'note-container')]";

    private final String CREATE_NOTE_POPUP_XPATH = "//div[@class='modal-content'][.//div[@id='note-modal-title-new_empty']]";

    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class, 'Card_containerNew')]")
    private WebElement addNoteButton;

    @FindBy(xpath = CREATE_NOTE_POPUP_XPATH)
    private WebElement createNotePopup;

    @FindBy(xpath = CREATE_NOTE_POPUP_XPATH + "//div[@id='note-modal-title-new_empty']")
    private WebElement createNotePopupTitleField;

    @FindBy(xpath = CREATE_NOTE_POPUP_XPATH + "//div[@id='note-modal-content-new_empty']")
    private WebElement createNotePopupContentField;

    @FindBy(xpath = CREATE_NOTE_POPUP_XPATH + "//button[@id='note-modal-save-btn-new_empty']")
    private WebElement createNotePopupSaveButton;

    @FindBy(xpath = CREATE_NOTE_POPUP_XPATH + "//button[@aria-label='Close']")
    private WebElement createNotePopupCloseButton;

    @FindAll
            (
                    {
                            @FindBy(xpath = NOTE_XPATH)
                    }
            )
    private List<WebElement> notes;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean urlIsMainPage() {
        boolean flag = false;
        String url = driver.getCurrentUrl();
        if (url.equals(BASE_URI + "content"))
            flag = true;
        return flag;
    }

    public boolean isAddNoteButtonDisplayed() {
        return addNoteButton.isDisplayed();
    }

    public void clickAddNoteButton() {
        addNoteButton.click();
    }

    private WebElement getNote(String noteTitle) {
        return driver.findElement(By.xpath(NOTE_XPATH + "[.//p[text()='" + noteTitle + "']]"));
    }

    public boolean noteIsDisplayed(String noteTitle) {
        return getNote(noteTitle).isDisplayed();
    }

    public String getNoteContent(String noteTitle) {
        return getNote(noteTitle).findElement(By.xpath(".//div[contains(@class, 'Card_body')]")).getText();
    }

    public void clickDeleteNoteButton(String noteTitle) {
        getNote(noteTitle).findElement(By.xpath(".//img[contains(@id, 'note-edit')]")).click();
    }

    public void clickEditNoteButton(String noteTitle) {
        getNote(noteTitle).findElement(By.xpath(".//img[contains(@id, 'note-delete')]")).click();
    }


    public boolean notesIsDisplayed() {
        boolean flag = true;
        for (WebElement el:notes) {
            if (!el.isDisplayed()) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean logoutButtonIsDisplayed() {
        return logoutButton.isDisplayed();
    }
}
