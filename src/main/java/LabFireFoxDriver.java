import lombok.Getter;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

@Getter
public class LabFireFoxDriver {
    WebDriver fireFoxDriver;

    public LabFireFoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
        fireFoxDriver = new FirefoxDriver(firefoxOptions);
        fireFoxDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        fireFoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
