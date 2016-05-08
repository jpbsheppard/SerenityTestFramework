package serenity.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

/**
 * hpe on 07/05/2016.
 */
public class MemorableQuestionsPage1 extends PageObject{

  //  private WebDriver driver;

    //locators

    //Memorable Question1 field
    @FindBy(id = "memorableQuestionsForm:memorableQuestionAnswer1")
    public WebElement memQuestionField1;

    @FindBy(xpath = ".//*[@id='memorableQuestionsForm']/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/label")
    public WebElement memQuestionLabel1;

    //Memorable Question2 field
    @FindBy(id = "memorableQuestionsForm:memorableQuestionAnswer2")
    public WebElement memQuestionField2;

    @FindBy(xpath = ".//*[@id='memorableQuestionsForm']/div[1]/div[2]/div[1]/table/tbody/tr[2]/td[1]/label")
    public WebElement memQuestionLabel2;

    //Memorable Question submit button
    @FindBy(id = "memorableQuestionsForm:loginButton")
    public WebElement memQuestionSubmitButton;

    //error message when device not trusted
    @FindBy(className = "errormsg")
    private WebElement errorMessage;
/*
    //contructor
    public MemorableQuestionsPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
*/

}
