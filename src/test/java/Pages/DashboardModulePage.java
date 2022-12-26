package Pages;

import Utilities.ParametersWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardModulePage extends Parent{
    public DashboardModulePage() { // Parametresiz Constructor
        PageFactory.initElements(ParametersWebDriver.getDriver(), this);
    }
// @FindBy yöntemi ile locator leri bulup private olarak WebElement veya list<WebElement> tipinde değişkenlere atama işlemi yapıyorum.

    @FindBy(xpath = "//*[text()='Events']")
    private WebElement eventText;
    @FindBy(css = "[class=login-header]")
    private WebElement loginForm;
    @FindBy(css = "[class='mat-card-content']")
    private WebElement noRegistrationMessage;
    @FindBy(css = "[title='Participants']")
    private WebElement participantListClick;
    @FindBy(css = ".mat-dialog-title")
    private WebElement participantList;

    WebElement myElement; // WebElement tipinde bir değişken oluşturdum ilgili eşitleme işlemlerini bu değişken ile yapacağım.

    public void findAndClick(String strlement) {
        switch (strlement) { //Bu metoda String tipinde gelen ifade ilgili caseye giderek eşitleme işlemini yapar.
            case "participantListClick" :myElement = participantListClick;break;
        }
        clickFunction(myElement); // Yapılan eşitleme işleminden sonra elemente tıklama işlemi için metoda gönderiyorum.
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
              case "noRegistrationMessage"  : myElement = noRegistrationMessage;break;
              case "participantList"        : myElement = participantList;break;

        }
        verifyContainsTextFunction(myElement, text); // Yapılan eşitleme işleminden sonra elementi doğrulama işlemi için değeri ile beraber metoda gönderiyorum.
    }
    public void containUrl(String strlement, String text) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
               case "eventText"    : myElement = eventText;break;
               case "loginForm"    : myElement = loginForm;break;
        }
        containsUrlFunction(myElement, text); // Yapılan eşitleme işleminden sonra url var mı sorgusu işlemi için metoda gönderiyorum.
    }

}
