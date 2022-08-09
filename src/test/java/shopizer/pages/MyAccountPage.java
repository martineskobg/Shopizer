package shopizer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import shopizer.config.CommonMethods;

public class MyAccountPage extends CommonMethods implements Page {
    public final WebElement username = driver.findElement(By.xpath("//div[1]/div[1]/div/input[@name='username']"));
    public final WebElement email = driver.findElement(By.xpath("//div[2]/div/input[@name='email']"));
    public WebElement accountManagementSection = driver.findElement(By.xpath("//div[@class='accordion']" +
            "/div[5]/div[1]/button[@type='button']/h3[@class='panel-title']"));;
    public WebElement deleteAccountButton;
    public WebElement confirmationButton;

    public void deleteMyAccount(){
        scrollToTheElement(accountManagementSection);
        accountManagementSection.click();
        deleteAccountButton = driver.findElement(By.xpath("//div[@class='myaccount-area pb-80 pt-100']//div[@class='row']//div[@class='collapse show']//button[@type='button']"));
        deleteAccountButton.click();
        confirmationButton = driver.findElement(By.xpath("//div[5]/div/div/p/a[2]"));
        confirmationButton.click();

    }
}
