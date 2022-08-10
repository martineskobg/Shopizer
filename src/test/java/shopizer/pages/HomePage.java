package shopizer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import shopizer.config.CommonMethods;
public class HomePage extends CommonMethods implements Page {

    public final WebElement footerLoginLink = driver.findElement(By.xpath("//div[@class='footer-list']//a[.='Login']"));
    public final WebElement footerRegistrationLink = driver.findElement(By.xpath("//div[@class='footer-list']//a[.='Register']"));

}
