import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LabChromeDriver l = new LabChromeDriver();
        WebDriver w = l.getChromeDriver();
        w.get("https://auto.ru/");
        MainPage.showCars(w);
        CarsPage.changeMark(w, "BMW");
    }
}
