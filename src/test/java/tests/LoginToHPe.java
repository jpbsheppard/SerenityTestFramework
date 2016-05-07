package tests;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import pageObjects.GluuPage;
import pageObjects.LoginPage;
import pageObjects.MemorableQuestionsPage1;
import pageObjects.PasswordPage;


/**
 * hpe on 06/05/2016.
 */
public class LoginToHPe {
    public static ProfilesIni listProfiles = new ProfilesIni();
    public static FirefoxProfile profile = listProfiles.getProfile("Selenium");
    public static WebDriver driver = new FirefoxDriver(profile);

    @Before
    public void goToLogin(){

        driver.get("https://gluuidp.hp.clients.amido.com/");
    }
    
    //Happy Path
    @Test
    public void userLogsInWithCameronShouldBeSuccess(){
        LoginPage login = new LoginPage(driver);
        String userName = "Cameron";

        //login
        login.enterUsername(userName);
        login.clickLoginButton();

        //password page
        PasswordPage pp = new PasswordPage(driver);
        pp.waitForPasswordPage();
        pp.setPasswordFormEntry1();
        pp.setPasswordFormEntry2();
        pp.setPasswordFormEntry3();
        pp.clickSubmitButton();

        //memorable questions
        MemorableQuestionsPage1 mqp1 = new MemorableQuestionsPage1(driver);
        mqp1.waitForMemorableQuestion1Page();
        mqp1.enterMemorableAnswer1();
        mqp1.enterMemorableAnswer2();
        mqp1.clickSubmitButton();

        //AssertSuccess
        GluuPage gluu = new GluuPage(driver);
        gluu.waitForGluuPageToLoad();

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
