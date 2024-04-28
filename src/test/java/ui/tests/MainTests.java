package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static data.Properties.STANDARD_PASSWORD;

@DisplayName("Проверка главной страницы UI")
public class MainTests extends BaseTest{

    @Test
    @DisplayName(value = "Проверка создания заметки")
    public void checkCreatedNote() {
        commonSteps.saveValueInMap("login", "DtestUser");
        commonSteps.saveValueInMap("title", "Заголовок1");
        commonSteps.saveValueInMap("content", "Контент1");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        mainSteps.clickAddNoteButton();
        mainSteps.notePopupShouldBeDisplayed();
        mainSteps.fillInNoteTitle(commonSteps.getValueFromValueMap("title"));
        mainSteps.fillInNoteContent(commonSteps.getValueFromValueMap("content"));
        mainSteps.clickSaveNoteButton();
        mainSteps.notePopupShouldNotBeVisible();
        mainSteps.checkThatNoteWithTitleDisplayedWithStaleException(commonSteps.getValueFromValueMap("title"));
        mainSteps.checkContentNoteWithTitleWithStaleException(commonSteps.getValueFromValueMap("title"),
                commonSteps.getValueFromValueMap("content"));

        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка создания заметки без заголовка")
    public void checkCreatedNoteWithoutTitle() {
        commonSteps.saveValueInMap("login", "DtestUser");
        commonSteps.saveValueInMap("content", "Контент1");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        mainSteps.clickAddNoteButton();
        mainSteps.notePopupShouldBeDisplayed();
        mainSteps.fillInNoteContent(commonSteps.getValueFromValueMap("content"));
        mainSteps.clickSaveNoteButton();
        mainSteps.notePopupShouldNotBeVisible();
        mainSteps.checkThatNoteWithTitleDisplayedWithStaleException("Заголовок...");
        mainSteps.checkContentNoteWithTitleWithStaleException("Заголовок...",
                commonSteps.getValueFromValueMap("content"));

        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка создания заметки без содержания")
    public void checkCreatedNoteWithoutContent() {
        commonSteps.saveValueInMap("login", "DtestUser");
        commonSteps.saveValueInMap("title", "Заголовок1");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        mainSteps.clickAddNoteButton();
        mainSteps.notePopupShouldBeDisplayed();
        mainSteps.fillInNoteTitle(commonSteps.getValueFromValueMap("title"));
        mainSteps.fillInNoteContent("Содержание...");
        mainSteps.clickSaveNoteButton();
        mainSteps.notePopupShouldNotBeVisible();
        mainSteps.checkThatNoteWithTitleDisplayedWithStaleException(commonSteps.getValueFromValueMap("title"));
        mainSteps.checkContentNoteWithTitleWithStaleException(commonSteps.getValueFromValueMap("title"), "Содержание...");

        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка создания заметки без заголовка и содержания")
    public void checkCreatedNoteWithoutTitleAndContent() {
        commonSteps.saveValueInMap("login", "DtestUser");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        mainSteps.clickAddNoteButton();
        mainSteps.notePopupShouldBeDisplayed();
        mainSteps.clickSaveNoteButton();
        mainSteps.dialogWindowShouldBeVisible();
        mainSteps.checkDialogWindowTitle("Сохранение");
        mainSteps.checkDialogWindowText("Укажите название или текст заметки");

        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка редактирования заметки")
    public void checkEditNote() {
        commonSteps.saveValueInMap("login", "DtestUser");
        commonSteps.saveValueInMap("title", "Заголовок1");
        commonSteps.saveValueInMap("content", "Контент1");
        commonSteps.saveValueInMap("title2", "Заголовок2");
        commonSteps.saveValueInMap("content2", "Контент2");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));
        dbSteps.addNote(commonSteps.getValueFromValueMap("login"), commonSteps.getValueFromValueMap("title"),
                commonSteps.getValueFromValueMap("content"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        mainSteps.checkThatNoteWithTitleDisplayed(commonSteps.getValueFromValueMap("title"));
        mainSteps.clickEditNoteButton(commonSteps.getValueFromValueMap("title"));
        mainSteps.notePopupShouldBeDisplayed();
        mainSteps.checkPopupNoteTitle(commonSteps.getValueFromValueMap("title"));
        mainSteps.checkPopupNoteContent(commonSteps.getValueFromValueMap("content"));
        mainSteps.clearPopupNoteTitle();
        mainSteps.clearPopupNoteContent();
        mainSteps.fillInNoteTitle(commonSteps.getValueFromValueMap("title2"));
        mainSteps.fillInNoteContent(commonSteps.getValueFromValueMap("content2"));
        mainSteps.clickSaveNoteButton();
        mainSteps.notePopupShouldNotBeVisible();
        mainSteps.checkThatNoteWithTitleDisplayedWithStaleException(commonSteps.getValueFromValueMap("title2"));
        mainSteps.checkContentNoteWithTitleWithStaleException(commonSteps.getValueFromValueMap("title2"),
                commonSteps.getValueFromValueMap("content2"));

        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

    @Test
    @DisplayName(value = "Проверка удаления заметки")
    public void checkDeleteNote() {
        commonSteps.saveValueInMap("login", "DtestUser");
        commonSteps.saveValueInMap("title", "Заголовок1");
        commonSteps.saveValueInMap("content", "Контент1");
        dbSteps.createUserWithStandardPassword(commonSteps.getValueFromValueMap("login"));
        dbSteps.addNote(commonSteps.getValueFromValueMap("login"), commonSteps.getValueFromValueMap("title"),
                commonSteps.getValueFromValueMap("content"));

        authorizationSteps.openAuthorizationPage();
        authorizationSteps.fillInLogin(commonSteps.getValueFromValueMap("login"));
        authorizationSteps.fillInPassword(STANDARD_PASSWORD);
        authorizationSteps.clickLoginButton();
        mainSteps.checkThatMainPageOpen();
        mainSteps.checkThatNoteWithTitleDisplayed(commonSteps.getValueFromValueMap("title"));
        mainSteps.clickDeleteButton(commonSteps.getValueFromValueMap("title"));
        mainSteps.dialogWindowShouldBeVisible();
        mainSteps.checkDialogWindowTitle("Удаление");
        mainSteps.checkDialogWindowText("Удалить заметку?");
        mainSteps.clickDialogWindowAcceptButton();
        mainSteps.checkNotesCount(0);

        dbSteps.fullDeleteUser(commonSteps.getValueFromValueMap("login"));
    }

}
