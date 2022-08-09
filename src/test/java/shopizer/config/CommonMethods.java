package shopizer.config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import shopizer.config.Base;
import shopizer.pages.HomePage;

public class CommonMethods extends Base {
    /**
     *  Click on given Webelement
     *
     * @param webElement WebElement object
     */
    public static void clickOnWebElement(WebElement webElement){
        webElement.click();
    }

    /**
     *  Scroll page (up and down) to given WebElement
     *
     * @param webElement WebElement object
     */
    public static void  scrollToTheElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    /**
     *  Takes the attribute "value" of given field
     *
     * @param field WebElement object
     * @return String
     */
    public static String getFieldText(WebElement field){
        return field.getAttribute("value");
    }

    /**
     * Takes the text from given WebElement
     *
     * @param errorElement
     * @return String
     */
    public static String getErrorMessage(WebElement errorElement){
        return errorElement.getText();
    }


}
