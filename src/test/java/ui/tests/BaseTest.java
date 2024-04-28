package ui.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.steps.AuthorizationSteps;
import ui.steps.CommonSteps;
import api.steps.DBSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.steps.MainSteps;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static data.Properties.IMPLICITLY_WAIT_SECOND;

public class BaseTest {

    public static AuthorizationSteps authorizationSteps;
    public static MainSteps mainSteps;
    public static WebDriver driver;
    public static DBSteps dbSteps;
    public static CommonSteps commonSteps;
    public static Map<String, String> savedValues;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECOND));
        authorizationSteps = new AuthorizationSteps();
        mainSteps = new MainSteps();
        dbSteps = new DBSteps();
        commonSteps = new CommonSteps();
        savedValues = new HashMap<>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
