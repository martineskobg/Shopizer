package shopizer.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import shopizer.pages.HomePage;
import shopizer.pages.LoginPage;

import java.net.MalformedURLException;

import static shopizer.config.Base.driver;
import static shopizer.config.CommonMethods.clickOnWebElement;
import static shopizer.config.CommonMethods.scrollToTheElement;
import static shopizer.pages.Page.homePageUrl;
import static shopizer.pages.Page.loginPageUrl;


public class SuccessfulLoginSteps {
    private final String validEmailAddress = "marto_vb@abv.bg";
    private final String validPassword = "Marto123456@";

    @Given("User navigate to Login form of Shopizer")
    public void user_navigate_to_login_form_of_shopizer() throws MalformedURLException {
        System.out.println("Navigate to the Login page");
        driver.get(homePageUrl);
        HomePage homePage = new HomePage();
        scrollToTheElement(homePage.footerLoginLink);
        clickOnWebElement(homePage.footerLoginLink);
    }

    @When("I submit the login form with valid credentials")
    public void submitLoginForm_withValidCred() {
        LoginPage loginPage = new LoginPage();
        System.out.println("Login with valid email and password");
        loginPage.login(validEmailAddress, validPassword);
    }

    @Then("Verify I'm on My account page")
    public void verify_i_m_in_my_account_page() {
        System.out.println("Verify expected URL with actual URL");
        String actualUrl = driver.getCurrentUrl();
        String message = "The Expected URL: "+ loginPageUrl + " Is noT equal to the actual URL: " + actualUrl;
        Assertions.assertEquals(loginPageUrl, actualUrl, message);
        driver.close();
    }
}


