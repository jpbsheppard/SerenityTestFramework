package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * hpe on 07/05/2016.
 */
public class LoginPage {
    private WebDriver driver;

    private static String loginPageUrl = "https://gluuidp.hp.clients.amido.com/";

    //locators

    //Login usernameField
    @FindBy(id = "loginForm:username")
    private WebElement usernameField;

    //username loginButton
    @FindBy(id = "loginForm:loginButton")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(loginPageUrl);
        PageFactory.initElements(driver, this);
    }

    //methods
    public void clickLoginButton(){
        loginButton.click();
    }

    public void enterUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
}
