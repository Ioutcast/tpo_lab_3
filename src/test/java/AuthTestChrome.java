import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTestChrome {
    private static LabChromeDriver labChromeDriver;
    private static WebDriver driver;
    private static String _login;
    private static String _password;
    private static String _wrongpassword;

    @BeforeEach
    void init() {
        labChromeDriver = new LabChromeDriver();
        driver = labChromeDriver.getChromeDriver();
        _login = "itmostud";
        _password = "Tpo_pass_itmo_stud";
        _wrongpassword = "Tpo_pass_itmo_stud1";

    }

    @AfterAll
    static void closeDriver() {
        driver.close();
        driver.quit();
    }

    @Test
    void loginTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        Auth.login(driver, _login, _password);
        WebElement loginButtonOnAuto = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[contains(@class, 'Link HeaderUserMenu__avatar')]/img"))));
        assertEquals("img", loginButtonOnAuto.getTagName());
        driver.manage().deleteAllCookies();
    }

    @Test
    void loginTestWithWrongPassword() throws InterruptedException {
        driver.get("https://auto.ru/");
        Auth.login(driver, _login, _wrongpassword);
        Thread.sleep(5000);
        WebElement loginButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Войдите, чтобы продолжить']"))));
        assertEquals("Войдите, чтобы продолжить", loginButton.getText());
    }

}
