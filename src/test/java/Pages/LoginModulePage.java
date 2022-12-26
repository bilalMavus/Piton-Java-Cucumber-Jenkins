package Pages;

import Utilities.ParametersWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModulePage extends Parent {
    public LoginModulePage() { // Parametresiz Constructor
        PageFactory.initElements(ParametersWebDriver.getDriver(), this);
    }
// @FindBy yöntemi ile locator leri bulup private olarak WebElement veya list<WebElement> tipinde değişkenlere atama işlemi yapıyorum.
    @FindBy(css = "[class=login-header]")
    private WebElement loginForm;
    @FindBy(id = "username")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//*[text()='Login']")
    private WebElement loginButton;
    @FindBy(id = "mat-error-0")
    private WebElement userNameError;
    @FindBy(id = "mat-error-1")
    private WebElement passwordNameError;
    @FindBy(xpath = "//*[text()='Welcome Automation Test User']")
    private WebElement welcomeMessage;

    WebElement myElement; // WebElement tipinde bir değişken oluşturdum ilgili eşitleme işlemlerini bu değişken ile yapacağım.

     public void findAndSend(String strlement, String value) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
              case "userName" : myElement=userName;break;
              case "password" : myElement=password;break;
        }
        sendKeysFunction(myElement, value); // Yapılan eşitleme işleminden sonra elementi yazdırma işlemi için değeri ile beraber metoda gönderiyorum.
    }

    public void findAndClick(String strlement) {
        switch (strlement) { //Bu metoda String tipinde gelen ifade ilgili caseye giderek eşitleme işlemini yapar.
                case "loginButton" :myElement = loginButton;break;
        }
        clickFunction(myElement); // Yapılan eşitleme işleminden sonra elemente tıklama işlemi için metoda gönderiyorum.
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
              case "loginForm"         : myElement = loginForm;break;
              case "userNameError"     : myElement = userNameError;break;
              case "passwordNameError" : myElement = passwordNameError;break;
              case "welcomeMessage"    : myElement = welcomeMessage;break;
        }
        verifyContainsTextFunction(myElement, text); // Yapılan eşitleme işleminden sonra elementi doğrulama işlemi için değeri ile beraber metoda gönderiyorum.
    }

    public void containElement(String strlement) {
        switch (strlement) { //Bu metoda String tipinde gelen ifadeler ilgili caseye giderek eşitleme işlemini yapar
            case "userName"    : myElement = userName;break;
            case "password"    : myElement = password;break;
            case "loginButton" : myElement = loginButton;break;
        }
       doesItContainElement(myElement); // Yapılan eşitleme işleminden sonra element var mı sorgusu işlemi için metoda gönderiyorum.
    }
}