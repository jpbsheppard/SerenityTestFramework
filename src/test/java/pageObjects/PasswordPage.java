package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * hpe on 07/05/2016.
 */
public class PasswordPage {
    private WebDriver driver;

    //locators

    //Password entry 1
    @FindBy(id = "passwordValidationForm:answer1")
    private WebElement passwordFormEntry1;

    //Password entry 2
    @FindBy(id = "passwordValidationForm:answer2")
    private WebElement passwordFormEntry2;

    //Password entry 3
    @FindBy(id = "passwordValidationForm:answer3")
    private WebElement passwordFormEntry3;

    @FindBy(id = "passwordValidationForm:loginButton")
    private WebElement passwordSubmitButton;

    //contructor
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods

    public void waitForPasswordPage(){
        WebDriverWait waitForPasswordCharField = new WebDriverWait(driver, 2);
        waitForPasswordCharField.until(ExpectedConditions.elementToBeClickable(passwordFormEntry1));
    }

    public void setPasswordFormEntry1(){
        WebElement char1 = driver.findElement(By.xpath("//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/label"));
        String C1 = char1.getText();
        passwordFormEntry1.clear();
        passwordFormEntry1.sendKeys(C1);
    }

    public void setPasswordFormEntry2() {
        WebElement char2 = driver.findElement(By.xpath(".//*[@id='passwordValidationForm\']/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label"));
        String C2 = char2.getText();
        passwordFormEntry2.clear();
        passwordFormEntry2.sendKeys(C2);
    }

    public void setPasswordFormEntry3() {
        WebElement char3 = driver.findElement(By.xpath("//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[1]/label"));
        String C3 = char3.getText();
        passwordFormEntry3.clear();
        passwordFormEntry3.sendKeys(C3);
    }

    public void clickSubmitButton(){
        passwordSubmitButton.click();
    }
}
