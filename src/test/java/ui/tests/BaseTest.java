package ui.tests;

import ui.pages.AuthorizationPage;
import ui.pages.MainPage;
import ui.steps.AuthorizationSteps;
import ui.steps.DBSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

//    public static AuthorizationPage authorizationPage;
    public static AuthorizationSteps authorizationSteps;
    public static MainPage mainPage;
    public static WebDriver driver;
    public static DBSteps dbSteps;


    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        authorizationPage = new AuthorizationPage(driver);
        authorizationSteps = new AuthorizationSteps();
        mainPage = new MainPage(driver);
        dbSteps = new DBSteps();
        dbSteps.deleteNotes(6);
        dbSteps.addRandomNote(6);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        dbSteps.deleteNotes(6);
    }
}
