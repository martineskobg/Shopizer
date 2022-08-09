package shopizer.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

import static shopizer.config.Base.driver;
import static shopizer.config.Base.startBrowser;

public class Hooks {
    @Before
    public static void runDriver() throws MalformedURLException {
        System.out.println("Start WebDriver");
        startBrowser();
    }

    @After
    public void quitDriver() {
        System.out.println("Quit WebDriver");
        driver.quit();
    }
}
