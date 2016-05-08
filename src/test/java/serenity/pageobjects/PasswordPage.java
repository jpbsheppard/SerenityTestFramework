package serenity.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * hpe on 07/05/2016.
 */
public class PasswordPage extends PageObject{
 //   private WebDriver driver;

    //locators

    //Password entry 1
    @FindBy(id = "passwordValidationForm:answer1")
    public WebElement passwordFormEntry1;

    @FindBy(xpath = "//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/label")
    public WebElement passwordlabel1;

    //Password entry 2
    @FindBy(id = "passwordValidationForm:answer2")
    public WebElement passwordFormEntry2;

    @FindBy(xpath = "//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label")
    public WebElement passwordlabel2;

    //Password entry 3
    @FindBy(id = "passwordValidationForm:answer3")
    public WebElement passwordFormEntry3;

    @FindBy(xpath = "//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[1]/label")
    public WebElement passwordlabel3;

    @FindBy(id = "passwordValidationForm:loginButton")
    public WebElement passwordSubmitButton;
/*
    //contructor
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
*/

}
