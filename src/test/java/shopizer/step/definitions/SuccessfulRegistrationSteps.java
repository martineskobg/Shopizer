package shopizer.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import shopizer.pages.HomePage;
import shopizer.pages.MyAccountPage;
import shopizer.pages.RegistrationPage;

import java.net.MalformedURLException;

import static shopizer.config.Base.driver;
import static shopizer.config.CommonMethods.*;
import static shopizer.pages.Page.homePageUrl;


public class SuccessfulRegistrationSteps {
    private final String email = "testEmail@abv.bg";
    private final String password = "TestPass123!";
    private final String repeatPass = password;
    private final String firstName = "TestFirstName";
    private final String lastName = "TestLastName";
    private final String stateName = "Alberta";
    private final String country = "Canada";
    private MyAccountPage myAccountPage;
    private RegistrationPage registrationPage;

    @Given("User navigate to Registration form of Shopizer")
    public void user_navigate_to_registration_form_of_shopizer() throws MalformedURLException {
        System.out.println("Navigate to the Registration page");
        driver.get(homePageUrl);
        HomePage homePage = new HomePage();
        scrollToTheElement(homePage.footerRegistrationLink);
        clickOnWebElement(homePage.footerRegistrationLink);
        registrationPage = new RegistrationPage();
    }

    @When("I submit the registration form with valid credentials")
    public void i_submit_the_registration_form_with_valid_credentials() {
        System.out.println("Submit registration form");
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.populateRegistrationFields(email, password, repeatPass, firstName, lastName, country, stateName);
    }

    @Then("I verify the value of User Name field on my account page")
    public void i_verify_the_value_of_user_name_field_on_my_account_page() {
        System.out.println("Verify the Username in My Account page");
        myAccountPage = new MyAccountPage();
        String usernameFieldValue = getFieldText(myAccountPage.username);
        Assertions.assertEquals(email, usernameFieldValue, "Username is not corect!");

    }

    @Then("I Verify the value of Email Address field on my account page")
    public void i_verify_the_value_of_email_address_field_on_my_account_page() {
        System.out.println("Verify the Email Address in My Account page");
        scrollToTheElement(myAccountPage.email);
        String emailFieldValue = getFieldText(myAccountPage.email);
        Assertions.assertEquals(email, emailFieldValue, "Email Address is not correct!");
        System.out.println("Delete Account");
        myAccountPage.deleteMyAccount();
    }
}
