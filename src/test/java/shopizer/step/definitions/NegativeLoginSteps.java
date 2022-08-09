package shopizer.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import shopizer.pages.LoginPage;

import static shopizer.config.Base.driver;
import static shopizer.pages.Page.loginPageUrl;

public class NegativeLoginSteps {
    private LoginPage loginPage;
    private String errorText;

    @Given("I'm on the login page")
    public void i_m_on_the_login_page() {
        System.out.println("Open Login page");
        driver.get(loginPageUrl);
        loginPage = new LoginPage();
    }

    @When("I enter {string}")
    public void i_provide_and(String email) {
        System.out.println("Enter  invalid value for Email address");
        // Set value for Email address and save the error message
        errorText = loginPage.getEmailErrorMessage(email);
    }

    @Then("I should see error message for invalid email")
    public void i_should_see_error_() {
        System.out.println("Verify the email error message");
        String expectedErrorText = "Please entered the valid email id";
        Assertions.assertEquals(expectedErrorText, errorText, "The error message is not correct");
    }

    @When("I submit the login form with incorrect {string} and {string}")
    public void iSubmitTheLoginFormWithIncorrectAnd(String email, String password) {
        System.out.println("Submitting the login form with wrong credentials");
        loginPage.login(email, password);
    }

    @Then("I should be on the same page")
    public void iShouldBeOnTheSamePage() {
        System.out.println("Assert the URL");
        String actualURl = driver.getCurrentUrl();
        Assertions.assertEquals(loginPageUrl, actualURl, "User is not on the same page");
    }

}
