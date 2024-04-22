package ui.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected void editImplicitlyWait(int second, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
