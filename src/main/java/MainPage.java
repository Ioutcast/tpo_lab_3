import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    public static void showCars(WebDriver driver) throws InterruptedException {

        Helper.disableAdd(driver);

        WebElement allAdt = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'IndexSelector__submit')]/button/span/span"))));
        allAdt.click();

    }

    public static void changeRegion(WebDriver driver, String region) throws InterruptedException {
        Helper.disableAdd(driver);
        WebElement allAdt = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'TopNavigationIndicators ')]/div/div/div[1]/span"))));
        allAdt.click();

        Thread.sleep(2000);

        WebElement closeButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'Popup_visible')]/div/div[2]/div/div[1]/button"))));
        closeButton.click();

        WebElement sityInput = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'Popup_visible')]/div/div[1]/label/div/span"))));
        Actions changeSity = new Actions(driver);
        changeSity.moveToElement(sityInput)
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(region)
                .keyDown(Keys.DOWN)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.DOWN)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.ENTER)
                .pause(Duration.ofSeconds(2))
                .release().build().perform();

        Thread.sleep(2000);

        WebElement save = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'Popup_visible')]/div/div[2]/div/button/span/span"))));

        Thread.sleep(2000);
        save.click();

    }

    public static void quickSearch(WebDriver driver, String searchBody) throws InterruptedException {
        Helper.disableAdd(driver);

        WebElement seachLookClick = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'SearchLineSuggest__input')]/span"))));

        Actions inputInSearch = new Actions(driver);
        inputInSearch.moveToElement(seachLookClick)
                .click()
                .pause(Duration.ofSeconds(2))
                .sendKeys(searchBody)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.ENTER)
                .release().build().perform();
        Thread.sleep(5000);
    }

}
