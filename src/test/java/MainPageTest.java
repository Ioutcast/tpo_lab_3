import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {

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
    }

    @Test
    void showCarsTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.showCars(driver);
        assertEquals("https://auto.ru/sankt-peterburg/cars/all/", driver.getCurrentUrl());
    }

    @Test
    void changeRegionTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.changeRegion(driver, "Москва");
        System.out.println(driver.getCurrentUrl());
        assertEquals("https://auto.ru/moskva/", driver.getCurrentUrl());
    }

    @Test
    void quickSearchTest() throws InterruptedException {
        driver.get("https://auto.ru/");
        MainPage.quickSearch(driver, "Mercedes-Benz GLE Coupe AMG");
        assertTrue(driver.getCurrentUrl().contains("mercedes"));
    }
}
