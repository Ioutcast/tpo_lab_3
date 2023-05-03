import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Auth {

    public static void login(WebDriver driver, String _login, String _password) throws InterruptedException {
        try {
            Helper.disableAdd(driver);
        } catch (NoSuchElementException ex) {
            System.out.println("no ads idk :/");
        } finally {
            WebElement loginButtonOnAuto = (new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/header/div[1]/div/div[6]/a[1]/span/span"))));
            loginButtonOnAuto.click();

            Helper.waitUntilPageLoads(driver, Duration.ofSeconds(10));

            WebElement yandexIn = Helper.getElementBy(driver, By.xpath("/html/body/div[2]/div/div/div/form/div/div[3]/div[1]/a/span"));
            yandexIn.click();
            WebElement mailForLogin = Helper.getElementBy(driver, By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div/form/div/div[2]/div[1]/div[1]/button"));
            mailForLogin.click();

            WebElement mailInput = Helper.getElementBy(driver, By.xpath("//*[@id='passp-field-login']"));
            mailInput.clear();
            mailInput.sendKeys(_login);
            WebElement loginButtonYandexId_1 = Helper.getElementBy(driver, By.xpath("//*[@id='passp:sign-in']"));
            loginButtonYandexId_1.click();


            WebElement passInput = Helper.getElementBy(driver, By.xpath("//*[@id='passp-field-passwd']"));
            passInput.clear();
            passInput.sendKeys(_password);
            WebElement loginButtonYandexId_2 = Helper.getElementBy(driver, By.xpath("//*[@id='passp:sign-in']"));
            loginButtonYandexId_2.click();

            Helper.waitUntilPageLoads(driver, Duration.ofSeconds(10));
        }
    }

}
