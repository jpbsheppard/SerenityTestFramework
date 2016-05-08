package serenity.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * hpe on 07/05/2016.
 */
public class MemorableQuestionsPage2 extends PageObject{

    private WebDriver driver;

    //locators

    //Memorable Question1 field
    @FindBy(id = "memorableQuestionsForm:memorableQuestionAnswer1")
    private WebElement memQuestionField1;

    //Memorable Question2 field
    @FindBy(id = "memorableQuestionsForm:memorableQuestionAnswer2")
    private WebElement memQuestionField2;

    //Memorable Question submit button
    @FindBy(id = "memorableQuestionsForm:loginButton")
    private WebElement memQuestionSubmitButton;

    //error message
    @FindBy(className = "errormsg")
    private WebElement errorMessage;

    //contructor
    public MemorableQuestionsPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods

    @Step("Given that the second memorable questions page has loaded")
    public void waitForMemorableQuestion1Page(){
        WebDriverWait waitForPasswordCharField2 = new WebDriverWait(driver, 2);
        waitForPasswordCharField2.until(ExpectedConditions.elementToBeClickable(memQuestionField1));
    }

    @Step("Given the user has entered a correct memorable answer in the first box for the second set of questions")
    public void enterMemorableAnswer1(){
        WebElement memorableAnswer1LabelText = driver.findElement(By.xpath(".//*[@id='memorableQuestionsForm']/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/label"));
        String memorableAnswer1Text = memorableAnswer1LabelText.getText();
        String memorableAnswer1 = memorableAnswer1Text.substring(memorableAnswer1Text.indexOf('(')+1,memorableAnswer1Text.indexOf(')'));
        memQuestionField1.sendKeys(memorableAnswer1);
    }

    @Step("Given the user has entered a correct memorable answer in the second box for the second set of questions")
    public void enterMemorableAnswer2(){
        WebElement memorableAnswer2LabelText = driver.findElement(By.xpath(".//*[@id='memorableQuestionsForm']/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label"));
        String memorableAnswer2Text = memorableAnswer2LabelText.getText();
        String memorableAnswer2 = memorableAnswer2Text.substring(memorableAnswer2Text.indexOf('(')+1,memorableAnswer2Text.indexOf(')'));
        memQuestionField2.sendKeys(memorableAnswer2);
    }

    @Step("Given the user has submitted the answers on the second memorable questions page")
    public void clickSubmitButton(){
        memQuestionSubmitButton.click();
    }

    @Step("Then the user should see the {0} error message")
    public String getErrorMsg(WebElement errorMessage){
        String error = errorMessage.getText().toString();
        return error;
    }
}
