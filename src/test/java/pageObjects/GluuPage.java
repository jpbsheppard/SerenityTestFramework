package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * hpe on 07/05/2016.
 */
public class GluuPage {

   private WebDriver driver;

    @FindBy(tagName = "h1")
    WebElement heading;

    public GluuPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods

    public boolean isGluuPageOpen(){
        //Assertion

        return heading.getText().toString().contains("Welcome to your Gluu Identity Appliance!");

    }

    public void waitForGluuPageToLoad(){
        WebDriverWait waitUntilGluuPageLoads = new WebDriverWait(driver, 5);
        waitUntilGluuPageLoads.until(ExpectedConditions.titleIs("Gluu"));
    }


}
