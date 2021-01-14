import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    private static final String DRIVER_CHROME = "chrome";
    private static final String DRIVER_IE = "ie";
    private static final String DRIVER_FIREFOX = "firefox";
    private static final String HEADLESS_CHROME = "chrome-headless";

    public static WebDriver createDriver(String browserName) {
        if (DRIVER_CHROME.equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/yanns/Downloads/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (DRIVER_FIREFOX.equals(browserName)) {
            System.setProperty("webdriver.gecko.driver", "C:/Users/yanns/Downloads/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (DRIVER_IE.equals(browserName)) {
            System.setProperty("webdriver.ie.driver", "C:/Users/yanns/Downloads/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (HEADLESS_CHROME.equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/yanns/Downloads/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            System.out.println("Opção de Driver Inválida!!!");
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
