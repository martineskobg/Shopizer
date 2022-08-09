package shopizer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import shopizer.config.CommonMethods;

import java.util.List;

public class RegistrationPage extends CommonMethods implements Page {
    public final WebElement emailInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@type='email']"));
    public final WebElement passwordInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@type='password']"));
    public final WebElement repeatPasswordInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@name='repeatPassword']"));
    public final WebElement firstNameInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@name='firstName']"));
    public final WebElement lastNameInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@name='lastName']"));
    public final Select country = new Select(driver.findElement(By.xpath("//div[@class='login-input']/select")));
    public final WebElement stateAsInput = driver.findElement(By.xpath("//div[7]/input[@name='stateProvince']"));
    public final WebElement registerButton = driver.findElement(By.xpath("//div[@class='fade tab-pane active show']//button[@type='submit']"));

    /**
     * Populate all mandatory fields on registration page
     *
     * @param email String
     * @param password String
     * @param repeatPassword String
     * @param firstName String
     * @param lastName String
     * @param country String
     * @param stateName String
     */
    public void populateRegistrationFields(String email, String password, String repeatPassword, String firstName, String lastName, String country, String stateName) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(repeatPassword);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);

        // Need this check because both fields country and state are related
        if (!country.equals("")) {
            this.country.selectByVisibleText(country);
            if (!stateName.equals("")) {
                // This element change his type after selecting country
                Select state = new Select(driver.findElement(By.xpath("//div[7][@class='login-input']/select")));
                state.selectByVisibleText(stateName);
            }
        } else {
            if (!stateName.equals("")) {
                stateAsInput.sendKeys(stateName);
            }
        }
        clickOnWebElement(registerButton);
    }

    /**
     * It gets one or more error msg displayed on the page.
     * If the error msg missing or there are more than one msg it trows exception
     *
     * @return String
     * @throws Exception for missing msg or Exception for multiple messages
     */
    public String getErrorMsgOnRegistrationPage() throws Exception {
        List<WebElement> errorMsgElement = driver.findElements(By.xpath("//p[@class='error-msg']"));
        if (errorMsgElement.size() > 1) {
            throw new Exception("There are more then one error messages");
        }
        if (errorMsgElement.size() < 1) {
            throw new Exception("The Error message is missing");
        }
        return getErrorMessage(errorMsgElement.get(0));
    }
}