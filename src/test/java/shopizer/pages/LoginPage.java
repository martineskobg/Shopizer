package shopizer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import shopizer.config.CommonMethods;

public class LoginPage extends CommonMethods implements Page {
    public final WebElement emailInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@name='username']"));
    public final WebElement passwordInput = driver.findElement(By.xpath("//div[@class='login-input']/input[@name='loginPassword']"));
    public final WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']/span[text()='Login']"));
    public WebElement emailErrorMessage;

    /**
     * Set value for Email and Password  and submit the login form
     *
     * @param email    String
     * @param password String
     */
    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        scrollToTheElement(loginButton);
        loginButton.click();
    }

    public String getReactNotificationText() {
        WebElement notification = driver.findElement(By.xpath("//*[text()='Incorrect username or password']"));
        return notification.getText();
    }

    /**
     * Set value for Email Address and get the error message
     *
     * @param invalidEmail String
     * @return error message text
     */
    public String getEmailErrorMessage(String invalidEmail) {
        emailInput.sendKeys(invalidEmail);
        emailErrorMessage = driver.findElement(By.xpath("//p[@class='error-msg']"));
        // Return error message text
        return emailErrorMessage.getText();
    }
}
