package ui.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ui.pages.MainPage;
import ui.tests.BaseTest;

public class MainSteps {

    private MainPage mainPage = new MainPage(BaseTest.driver);

    @Step("Проверяем, что главная страница открылась")
    public void checkThatMainPageOpen() {
        Assert.assertEquals(true, mainPage.isAddNoteButtonDisplayed());
        Assert.assertEquals(true, mainPage.urlIsMainPage());
    }

    @Step("Нажимаем на кнопку добавления заметки")
    public void clickAddNoteButton() {
        mainPage.clickAddNoteButton();
    }

    @Step("Проверяем, что поп-ап заметки отображается")
    public void checkThatNotePopupDisplayed() {
        Assert.assertTrue(mainPage.notePopupIsDisplayed());
    }

    @Step("Вводим текст в поле ввода Заголовок заметки")
    public void fillInNoteTitle(String text) {
        mainPage.fillInNoteTitle(text);
    }

    @Step("Вводим текст в поле ввода Содержание заметки")
    public void fillInNoteContent(String text) {
        mainPage.fillInNoteContent(text);
    }

    @Step("Нажимаем кнопку сохранить заметку")
    public void clickSaveNoteButton() {
        mainPage.clickSaveNoteButton();
    }

    @Step("Проверяем, что заметка отображается")
    public void checkThatNoteWithTitleDisplayed(String noteTitle) {
        Assert.assertTrue(mainPage.noteIsDisplayed(noteTitle));
    }

    @Step("Проверяем, что заметка отображается")
    public void checkThatNoteWithTitleDisplayedWithStaleException(String noteTitle) {
        Assert.assertTrue(mainPage.noteIsDisplayedIgnoringStaleException(noteTitle));
    }

    @Step("Ждем, пока поп-ап заметки не пропадет")
    public void notePopupShouldNotBeVisible() {
        mainPage.notePopupShouldNotBeVisible();
    }

    @Step("Проверяем, контент в заметке")
    public void checkContentNoteWithTitle(String noteTitle, String expectedContent) {
        Assert.assertEquals(expectedContent, mainPage.getNoteContent(noteTitle));
    }

    @Step("Проверяем, контент в заметке")
    public void checkContentNoteWithTitleWithStaleException(String noteTitle, String expectedContent) {
        Assert.assertEquals(expectedContent, mainPage.getNoteContentIgnoringStaleException(noteTitle));
    }

    @Step("Нажимаем кнопку Изменить у заметки")
    public void clickEditNoteButton(String noteTitle) {
        mainPage.clickEditNoteButton(noteTitle);
    }

    @Step("Проверяем заголовок, в поп-апе заметки")
    public void checkPopupNoteTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, mainPage.getPopupTitleText());
    }

    @Step("Проверяем текст содержания, в поп-апе заметки")
    public void checkPopupNoteContent(String expectedContent) {
        Assert.assertEquals(expectedContent, mainPage.getPopupContentText());
    }

    @Step("Очищаем поле Заголовок в поп-апе заметки")
    public void clearPopupNoteTitle() {
        mainPage.clearNoteTitleField();
    }

    @Step("Очищаем поле Содержание в поп-апе заметки")
    public void clearPopupNoteContent() {
        mainPage.clearNoteContentField();
    }

    @Step("Проверяем, что диалоговое окно отображается")
    public void checkThatDialogDisplayed() {
        Assert.assertTrue(mainPage.dialogWindowDisplayed());
    }

    @Step("Проверяем заголовок диалогового окна")
    public void checkDialogWindowTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, mainPage.getDialogWindowTitleText());
    }

    @Step("Проверяем текст диалогового окна")
    public void checkDialogWindowText(String expectedText) {
        Assert.assertEquals(expectedText, mainPage.getDialogWindowMessageText());
    }

    @Step("Ждем пока появится диалоговое окно")
    public void dialogWindowShouldBeVisible() {
        mainPage.dialogWindowShouldBeVisible();
    }

    @Step("Нажимаем на кнопку удалить заметку")
    public void clickDeleteButton(String noteTitle) {
        mainPage.clickDeleteNoteButton(noteTitle);
    }

    @Step("Нажимаем на кнопку подтверждения в диалоговом окне")
    public void clickDialogWindowAcceptButton() {
        mainPage.clickDialogWindowAcceptButton();
    }

    @Step("Проверяем количество заметок")
    public void checkNotesCount(int expectedCount) {
        System.out.println(mainPage.getNotesCount());
        Assert.assertEquals(expectedCount, mainPage.getNotesCount());
    }

}
