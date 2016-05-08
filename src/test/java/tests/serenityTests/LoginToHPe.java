package tests.serenityTests;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenity.sceneriosteps.loginPageScenarioSteps;


/**
 * hpe on 06/05/2016.
 */
@RunWith(SerenityRunner.class)
public class LoginToHPe {

    @Managed(driver = "Firefox")
    WebDriver driver;

    @Steps
    loginPageScenarioSteps user;

    //Happy Path
    @Test()
    @Title("User successfully logs in with a username of Cameron")
    public void userLogsInWithCameronShouldBeSuccess(){

        String userName = "Cameron";

        //login
        user.enterUsername(userName);
        user.clickLoginButton();

        //password page

 //       user.waitForPasswordPage();
        user.setPasswordFormEntry1();
        user.setPasswordFormEntry2();
        user.setPasswordFormEntry3();
        user.clickSubmitButton();

        //memorable questions

  //      user.waitForMemorableQuestion1Page();
        user.enterMemorableAnswer1();
        user.enterMemorableAnswer2();
        user.clickMemorableQuestionSubmitButton();

        //AssertSuccess
        user.isGluuPageOpen();

    }
}
