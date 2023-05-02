import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarsPage {

    public static void changeMark(WebDriver driver, String markName) throws InterruptedException {
        //todo
        // firefox moment
        // Helper.disableAdd(driver);
        WebElement marka = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/button/span/span"))));
        System.out.println(marka.getAttribute("class"));
        marka.click();
        Actions action = new Actions(driver);
        action.moveToElement(marka)
                .doubleClick()
                .pause(Duration.ofSeconds(2))
                .sendKeys(markName)
                .keyDown(Keys.DOWN)
                .keyDown(Keys.ENTER)
                .release().build().perform();
        Thread.sleep(5000);
    }

    public static void clickOnAdt(WebDriver driver, int adtNum) throws InterruptedException {
        //37 - amount of adt when page loads
        if (adtNum > 37) throw new InterruptedException("wrong input adtNum");

        WebElement adt = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(.//div[contains(@class, 'ListingItem__main')]/div[2]/div[1]/h3/a)" + "[" + adtNum + "]"
                        ))));
        Thread.sleep(2000);
        adt.click();
        Thread.sleep(2000);
    }
}
