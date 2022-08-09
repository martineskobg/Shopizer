package shopizer.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    private static final ChromeOptions chromeOptions = new ChromeOptions();
    public static WebDriver driver;

    /**
     * Set up the Webdriver
     * @throws MalformedURLException
     */
    public static void startBrowser() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4545/"), chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
