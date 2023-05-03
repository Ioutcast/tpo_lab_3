import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsPageTestChrome {

    private static LabChromeDriver labChromeDriver;
    private static WebDriver driver;


    @BeforeEach
    void init() {
        labChromeDriver = new LabChromeDriver();
        driver = labChromeDriver.getChromeDriver();
    }

    @AfterEach
    void closeDriver() {
        driver.close();
        driver.quit();
    }

    @Test
    void changeMarkTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.showCars(driver);
        CarsPage.changeMark(driver, "BMW");
        assertTrue(driver.getCurrentUrl().contains("bmw"));

    }

    @Test
    void clickOnAdt() throws InterruptedException {
        driver.get("https://auto.ru/sankt-peterburg/cars/all/");
        Thread.sleep(5000);
        String originalWindow = driver.getWindowHandle();
        int elem = 1;
        WebElement adt = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(.//div[contains(@class, 'ListingItem__main')]/div[2]/div[1]/h3/a)" + "[" + elem + "]"
                        ))));
        String[] carName = adt.getText().split(" ");
        String expected = carName[0].toLowerCase() + "/" + carName[1].toLowerCase();

        CarsPage.clickOnAdt(driver, elem);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        assertTrue(driver.getCurrentUrl().contains(expected));

    }
}
