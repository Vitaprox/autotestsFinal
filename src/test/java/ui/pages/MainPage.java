package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static data.Properties.*;

public class MainPage extends BasePage{

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(WAIT_SECOND));
        PageFactory.initElements(driver, this);
    }

    private final String NOTE_XPATH = "//div[contains(@id, 'note-container')]";

    private final String NOTE_POPUP_XPATH = "//div[@class='modal-content'][.//div[contains(@id,'note-modal-title')]]";

    private final String MODAL_DIALOG_XPATH = "//div[@class='modal-dialog']";


    @FindBy(id = "logout-btn")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class, 'Card_containerNew')]")
    private WebElement addNoteButton;

    @FindBy(xpath = NOTE_POPUP_XPATH)
    private WebElement notePopup;

    @FindBy(xpath = NOTE_POPUP_XPATH + "//div[contains(@id,'note-modal-title')]")
    private WebElement notePopupTitleField;

    @FindBy(xpath = NOTE_POPUP_XPATH + "//div[contains(@id,'note-modal-content')]")
    private WebElement notePopupContentField;

    @FindBy(xpath = NOTE_POPUP_XPATH + "//button[contains(@id,'note-modal-save-btn')]")
    private WebElement notePopupSaveButton;

    @FindBy(xpath = NOTE_POPUP_XPATH + "//button[@aria-label='Close']")
    private WebElement notePopupCloseButton;

    @FindBy(xpath = MODAL_DIALOG_XPATH)
    private WebElement dialogWindow;

    @FindBy(xpath = MODAL_DIALOG_XPATH + "//div[contains(@class, 'modal-title')]")
    private WebElement dialogWindowTitle;

    @FindBy(xpath = MODAL_DIALOG_XPATH + "//div[contains(@class, 'modal-body')]")
    private WebElement dialogWindowMessage;

    @FindBy(xpath = MODAL_DIALOG_XPATH + "//button[contains(@class, 'btn-primary')]")
    private WebElement dialogWindowAcceptButton;

    @FindAll
            (
                    {
                            @FindBy(xpath = NOTE_XPATH)
                    }
            )
    private List<WebElement> notes;


    public boolean urlIsMainPage() {
        boolean flag = false;
        String url = driver.getCurrentUrl();
        if (url.equals(BASE_URI + "content"))
            flag = true;
        return flag;
    }

    public String getDialogWindowTitleText() {
        return dialogWindowTitle.getText();
    }

    public String getDialogWindowMessageText() {
        return dialogWindowMessage.getText();
    }

    public void clickDialogWindowAcceptButton() {
        dialogWindowAcceptButton.click();
    }

    public boolean dialogWindowDisplayed() {
        return dialogWindow.isDisplayed();
    }

    public void dialogWindowShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(dialogWindow));
    }

    public void notePopupShouldNotBeVisible() {
        editImplicitlyWait(0, driver);
        wait.until(ExpectedConditions.invisibilityOf(notePopup));
        editImplicitlyWait(IMPLICITLY_WAIT_SECOND, driver);
    }

    public boolean notePopupIsDisplayed() {
        return notePopup.isDisplayed();
    }

    public void notePopupShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(notePopup));
    }

    public void notePopupTitleShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(notePopupTitleField));
    }

    public void notePopupContentShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(notePopupContentField));
    }

    public void fillInNoteTitle(String text) {
        notePopupTitleField.sendKeys(text);
    }

    public void fillInNoteContent(String text) {
        notePopupContentField.sendKeys(text);
    }

    public void clearNoteTitleField() {
        notePopupTitleField.clear();
    }

    public void clearNoteContentField() {
        notePopupContentField.clear();
    }

    public String getPopupTitleText() {
        return notePopupTitleField.getText();
    }

    public String getPopupContentText() {
        return notePopupContentField.getText();
    }

    public void clickSaveNoteButton() {
        notePopupSaveButton.click();
    }

    public boolean isAddNoteButtonDisplayed() {
        return addNoteButton.isDisplayed();
    }

    public void addNoteButtonShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOf(addNoteButton));
    }

    public void clickAddNoteButton() {
        addNoteButton.click();
    }

    private WebElement getNote(String noteTitle) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NOTE_XPATH +
                "[.//p[text()='" + noteTitle + "']]")));
    }

    public boolean noteIsDisplayed(String noteTitle) {
        return getNote(noteTitle).isDisplayed();
    }

    public boolean noteIsDisplayedIgnoringStaleException(String noteTitle) {
        try {
            return noteIsDisplayed(noteTitle);
        } catch (StaleElementReferenceException e) {
            return noteIsDisplayed(noteTitle);
        }
    }

    public String getNoteContentIgnoringStaleException(String noteTitle) {
        try {
            return getNoteContent(noteTitle);
        } catch (StaleElementReferenceException e) {
            return getNoteContent(noteTitle);
        }
    }

    public String getNoteContent(String noteTitle) {
        return getNote(noteTitle).findElement(By.xpath(".//div[contains(@class, 'Card_body')]")).getText();
    }

    public void clickDeleteNoteButton(String noteTitle) {
        getNote(noteTitle).findElement(By.xpath(".//img[contains(@id, 'note-delete')]")).click();
    }

    public void clickEditNoteButton(String noteTitle) {
        getNote(noteTitle).findElement(By.xpath(".//img[contains(@id, 'note-edit')]")).click();
    }

    public int getNotesCount() {
        editImplicitlyWait(0, driver);
        int count = driver.findElements(By.xpath(NOTE_XPATH)).size();
        editImplicitlyWait(IMPLICITLY_WAIT_SECOND, driver);
        return count;
    }

    public boolean logoutButtonIsDisplayed() {
        return logoutButton.isDisplayed();
    }

}
