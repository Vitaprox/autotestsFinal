package ui.steps;

import org.junit.Assert;
import ui.pages.MainPage;
import ui.tests.BaseTest;

public class MainSteps {

    private MainPage mainPage = new MainPage(BaseTest.driver);

    public void checkThatMainPageOpen() {
        Assert.assertEquals(true, mainPage.isAddNoteButtonDisplayed());
        Assert.assertEquals(true, mainPage.urlIsMainPage());
    }
}
