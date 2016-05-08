package serenity.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * hpe on 07/05/2016.
 */
public class LoginPage extends PageObject {
    private WebDriver driver;

    private static String loginPageUrl = "https://gluuidp.hp.clients.amido.com/";

    //locators

    //Login usernameField
    @FindBy(id = "loginForm:username")
    public WebElement usernameField;

    //username loginButton
    @FindBy(id = "loginForm:loginButton")
    public WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(loginPageUrl);
        PageFactory.initElements(driver, this);
    }

}
