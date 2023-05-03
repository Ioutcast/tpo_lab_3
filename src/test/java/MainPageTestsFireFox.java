import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTestsFireFox {

    private static LabFireFoxDriver labChromeDriver;
    private static WebDriver driver;


    @BeforeEach
    void init() {
        labChromeDriver = new LabFireFoxDriver();
        driver = labChromeDriver.getFireFoxDriver();
    }

    @AfterEach
    void closeDriver() {
//        driver.close();
//        driver.quit();
    }

    @Test
    void showCarsTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.showCars(driver);
        Thread.sleep(1000);
        assertTrue(driver.getCurrentUrl().contains("cars"));
    }

    @Test
    void changeRegionTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.changeRegion(driver, "Москва");
        Thread.sleep(1000);
        assertEquals("https://auto.ru/moskva/", driver.getCurrentUrl());
    }

    @Test
    void quickSearchTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.quickSearch(driver, "Mercedes-Benz GLE Coupe AMG");
        assertTrue(driver.getCurrentUrl().contains("mercedes"));
    }
}
