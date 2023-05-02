import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    static void disableAdd(WebDriver driver) throws InterruptedException {
        WebElement disableAddButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Modal Modal_visible Modal_has-animation']/div/div[1]/div/div/div/div/div[3]/div/button[2]"))));
        disableAddButton.click();
        //todo _?
        Thread.sleep(2000);
    }

    public static void waitUntilPageLoads(WebDriver driver, Duration timeout) {
        WebDriverWait waitDriver = new WebDriverWait(driver, timeout);
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static WebElement getElementBy(WebDriver driver, By xpath) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

}
