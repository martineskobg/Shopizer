package shopizer.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import shopizer.config.Base;
import shopizer.config.CommonMethods;
import shopizer.pages.HomePage;
import shopizer.pages.RegistrationPage;

import java.net.MalformedURLException;

public class RegistrationTest extends CommonMethods {
    public final HomePage homePage = new HomePage();

    @BeforeClass
    public static void runDriver() throws MalformedURLException {
        //Base.startBrowser();
    }

    @Test
    public void registrationTest() {

        try {
//            homePage.userButton.click();
//
//            RegistrationPage registrationPage = homePage.clickRegistrationLink();
//
//            registrationPage.emailInput.sendKeys("marto@abv.bg");
//            registrationPage.passwordInput.sendKeys("Qwerty123*");
//            registrationPage.repeatPasswordInput.sendKeys("Qwerty123*");
//            registrationPage.firstNameInput.sendKeys("Martin");
//            registrationPage.lastNameInput.sendKeys("Bachev");
//            registrationPage.country.selectByIndex(1);
//            registrationPage.state.selectByIndex(1);


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
