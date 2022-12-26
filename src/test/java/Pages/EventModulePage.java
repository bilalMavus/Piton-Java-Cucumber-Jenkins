package Pages;

import Utilities.ParametersWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventModulePage extends Parent {
    public EventModulePage() { // Parametresiz Constructor
        PageFactory.initElements(ParametersWebDriver.getDriver(), this);
    }
// @FindBy yöntemi ile locator leri bulup private olarak WebElement veya list<WebElement> tipinde değişkenlere atama işlemi yapıyorum.
    @FindBy(xpath = "//*[text()='Login']")
    private WebElement loginButton;
    @FindBy(css = "[class='mat-button-wrapper']")
    private WebElement createEvent;
    @FindBy(xpath = "//*[text()='Create New Event']")
    private WebElement eventButton;
    @FindBy(id = "mat-error-2")
    private WebElement eventNameError;
    @FindBy(id = "mat-error-3")
    private WebElement eventDateError;
    @FindBy(id = "mat-error-4")
    private WebElement firstNameError;
    @FindBy(id = "mat-error-5")
    private WebElement lastNameError;
    @FindBy(id = "mat-error-6")
    private WebElement contactError;
    @FindBy(xpath = "//*[text()='Add Participant']")
    private WebElement addParticipant;
    @FindBy(xpath = "((//tr[@class='ng-star-inserted'])[2]/td)[1]")
    private WebElement content2ndRow;
    @FindBy(xpath = "//*[text()='delete']")
    private WebElement deleteButton;
    @FindBy(xpath = "//p[text()='Please add participant!']")
    private WebElement participantErrorMessage;
    @FindBy(id = "name")
    private WebElement eventName;
    @FindBy(id = "description")
    private WebElement eventDescription;
    @FindBy(css = "[fill='currentColor']>path")
    private WebElement dateClick;
    @FindBy(css = "[aria-label='Next month']")
    private WebElement nextMonthClick;
    @FindBy(xpath = "(//div[@class='mat-calendar-body-cell-content mat-focus-indicator'])[10]")
    private WebElement dayClick;
    @FindBy(xpath = "//*[@data-placeholder='Enter first name']")
    private WebElement firstName;
    @FindBy(xpath = "//*[@data-placeholder='Enter last name']")
    private WebElement lastName;
    @FindBy(xpath = "//*[@data-placeholder='Enter email or phone']")
    private WebElement contact;
    @FindBy(css = ".cdk-overlay-pane")
    private WebElement successfulMessage;
    @FindBy(xpath = "//*[text()='edit']")
    private WebElement editButton;
    @FindBy(xpath = "//*[text()='Update Event']")
    private WebElement updateEventButton;

    WebElement myElement; // WebElement tipinde bir değişken oluşturdum ilgili eşitleme işlemlerini bu değişken ile yapacağım.

    public void findAndSend(String strlement, String value) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
            case "eventName"        : myElement=eventName;break;
            case "eventDescription" : myElement=eventDescription;break;
            case "firstName"        : myElement=firstName;break;
            case "lastName"         : myElement=lastName;break;
            case "contact"          : myElement=contact;break;
        }
        sendKeysFunction(myElement, value); // Yapılan eşitleme işleminden sonra elementi yazdırma işlemi için değeri ile beraber metoda gönderiyorum.
    }

    public void findAndClick(String strlement) {
        switch (strlement) { //Bu metoda String tipinde gelen ifade ilgili caseye giderek eşitleme işlemini yapar.
            case "loginButton"        :myElement = loginButton;break;
            case "createEvent"        :myElement = createEvent;break;
            case "eventButton"        :myElement = eventButton;break;
            case "addParticipant"     :myElement = addParticipant;break;
            case "deleteButton"       :myElement = deleteButton;break;
            case "dateClick"          :myElement = dateClick;break;
            case "nextMonthClick"     :myElement = nextMonthClick;break;
            case "dayClick"           :myElement = dayClick;break;
            case "editButton"         :myElement = editButton;break;
            case "updateEventButton"  :myElement = updateEventButton;break;
        }
        clickFunction(myElement); // Yapılan eşitleme işleminden sonra elemente tıklama işlemi için metoda gönderiyorum.
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
            case "eventNameError"           : myElement = eventNameError;break;
            case "eventDateError"           : myElement = eventDateError;break;
            case "firstNameError"           : myElement = firstNameError;break;
            case "lastNameError"            : myElement = lastNameError;break;
            case "contactError"             : myElement = contactError;break;
            case "content2ndRow"            : myElement = content2ndRow;break;
            case "participantErrorMessage"  : myElement = participantErrorMessage;break;
            case "successfulMessage"        : myElement = successfulMessage;break;
        }
        verifyContainsTextFunction(myElement, text); // Yapılan eşitleme işleminden sonra elementi doğrulama işlemi için değeri ile beraber metoda gönderiyorum.
    }

    public void containElement(String strlement) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
             case "eventButton"        : myElement = eventButton;break;
             case "updateEventButton"  : myElement = updateEventButton;break;

        }
        doesItContainElement(myElement); // Yapılan eşitleme işleminden sonra element var mı sorgusu işlemi için metoda gönderiyorum.
    }

}
