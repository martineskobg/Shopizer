package shopizer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import shopizer.config.CommonMethods;
public class HomePage extends CommonMethods implements Page {
    public final WebElement footerLoginLink = driver.findElement(By.xpath("//div[3][@class=\"col-lg-3 col-sm-3\" ]//li[2]/a"));
    public final WebElement footerRegistrationLink = driver.findElement(By.xpath("//div[3][@class=\"col-lg-3 col-sm-3\" ]//li[3]/a"));

}
