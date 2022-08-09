package shopizer.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import shopizer.pages.RegistrationPage;

import static shopizer.config.Base.driver;
import static shopizer.pages.Page.registrationPageUrl;

public class NegativeRegistrationSteps {
    private RegistrationPage registrationPage;

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() {
        System.out.println("Open Registration page");
        driver.get(registrationPageUrl);
        registrationPage = new RegistrationPage();
    }

    @When("I submit registration form with one missing field {string}, {string}, {string}, {string}, {string}, {string} , {string}")
    public void i_submit_registration_form_with_one_missing_field(String email, String password, String repeatPassword, String firstName, String lastName, String country, String state) {
        System.out.println("Populate Registration Fields");
        registrationPage.populateRegistrationFields(email, password, repeatPassword, firstName, lastName, country, state);
    }

    @Then("I should see error the message {string}")
    public void i_should_see_error_the_message(String errorMessage) {
        System.out.println("Verify the error message");
        String errMsgText;
        try {
            errMsgText = registrationPage.getErrorMsgOnRegistrationPage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(errorMessage, errMsgText, "The Error Message text is not correct");
    }
}
