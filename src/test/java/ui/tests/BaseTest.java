package ui.tests;

import ui.pages.AuthorizationPage;
import ui.pages.MainPage;
import ui.steps.AuthorizationSteps;
import ui.steps.CommonSteps;
import ui.steps.DBSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.steps.MainSteps;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static data.Properties.IMPLICITLY_WAIT_SECOND;

public class BaseTest {

//    public static AuthorizationPage authorizationPage;
//    public static MainPage mainPage;
    public static AuthorizationSteps authorizationSteps;
    public static MainSteps mainSteps;
    public static WebDriver driver;
    public static DBSteps dbSteps;
    public static CommonSteps commonSteps;
    public static Map<String, String> savedValues;


    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECOND));
//        authorizationPage = new AuthorizationPage(driver);
//        mainPage = new MainPage(driver);
        authorizationSteps = new AuthorizationSteps();
        mainSteps = new MainSteps();
        dbSteps = new DBSteps();
        commonSteps = new CommonSteps();
        savedValues = new HashMap<>();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
