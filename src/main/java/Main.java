public class Main {

    private static final String _login = "itmostud";
    private static final String _password = "Tpo_pass_itmo_stud";

    public static void main(String[] args) throws InterruptedException {
        LabChromeDriver chromeDriver = new LabChromeDriver();

        chromeDriver.getChromeDriver().get("https://auto.ru/");

        MainPage.showCars(chromeDriver.getChromeDriver());


    }
}
