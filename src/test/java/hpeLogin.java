/**
 * hpe on 29/04/2016.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hpeLogin {

    public static ProfilesIni listProfiles = new ProfilesIni();
    public static FirefoxProfile profile = listProfiles.getProfile("Selenium");
    public static WebDriver driver = new FirefoxDriver(profile);

    @Before
    public void goToLogin(){

        driver.get("https://gluuidp.hp.clients.amido.com/");
    }


    //Happy Path
    @Test
    public void userLogsInWithCameron(){
        String userName = "Cameron";

        //login page
        WebElement useridInputField = driver.findElement(By.id("loginForm:username"));
        useridInputField.sendKeys(userName);
        driver.findElement(By.id("loginForm:loginButton")).click();

        //password character page
        WebElement passwordFormEntry1 = driver.findElement(By.id("passwordValidationForm:answer1"));
        WebDriverWait waitForPasswordCharField = new WebDriverWait(driver, 2);
        waitForPasswordCharField.until(ExpectedConditions.elementToBeClickable(passwordFormEntry1));

        //find elements
        WebElement char1 = driver.findElement(By.xpath("//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/label"));
        String C1 = char1.getText();
        WebElement char2 = driver.findElement(By.xpath(".//*[@id='passwordValidationForm\']/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label"));
        String C2 = char2.getText();
        WebElement char3 = driver.findElement(By.xpath("//*[@id=\"passwordValidationForm\"]/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[1]/label"));
        String C3 = char3.getText();
        WebElement passwordFormEntry2 = driver.findElement(By.id("passwordValidationForm:answer2"));
        WebElement passwordFormEntry3 = driver.findElement(By.id("passwordValidationForm:answer3"));

        //enter password characters
        passwordFormEntry1.sendKeys(C1);
        passwordFormEntry2.sendKeys(C2);
        passwordFormEntry3.sendKeys(C3);

        driver.findElement(By.id("passwordValidationForm:loginButton")).click();

        //Memorable Questions form
        WebDriverWait waitForPasswordCharField2 = new WebDriverWait(driver, 2);
        WebElement memQuestionField1 = driver.findElement(By.id("memorableQuestionsForm:memorableQuestionAnswer1"));
        waitForPasswordCharField2.until(ExpectedConditions.elementToBeClickable(memQuestionField1));

        WebElement memQuestionField2 = driver.findElement(By.id("memorableQuestionsForm:memorableQuestionAnswer2"));

        WebElement memorableAnswer1LabelText = driver.findElement(By.xpath(".//*[@id='memorableQuestionsForm']/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/label"));
        String memorableAnswer1Text = memorableAnswer1LabelText.getText();
        String memorableAnswer1 = memorableAnswer1Text.substring(memorableAnswer1Text.indexOf('(')+1,memorableAnswer1Text.indexOf(')'));

        WebElement memorableAnswer2LabelText = driver.findElement(By.xpath(".//*[@id='memorableQuestionsForm']/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label"));
        String memorableAnswer2Text = memorableAnswer2LabelText.getText();
        String memorableAnswer2 = memorableAnswer2Text.substring(memorableAnswer2Text.indexOf('(')+1,memorableAnswer2Text.indexOf(')'));

        memQuestionField1.sendKeys(memorableAnswer1);
        memQuestionField2.sendKeys(memorableAnswer2);

        driver.findElement(By.id("memorableQuestionsForm:loginButton")).click();

        //wait until gluu page loads
        WebDriverWait waitUntilGluuPageLoads = new WebDriverWait(driver, 2);
        waitUntilGluuPageLoads.until(ExpectedConditions.titleIs("Gluu"));

    }

   @After
    public void CloseBrowser(){
        driver.close();
    }


    @AfterClass
    public static void TearDown(){
        driver.quit();
    }
}

