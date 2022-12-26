package StepDefinitions;

import Pages.LoginModulePage;
import Utilities.ParametersWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginModuleSteps {
    LoginModulePage lmp = new LoginModulePage();

    @Given("Navigate to Piton")
    public void navigateToPiton() {
        ParametersWebDriver.getDriver().get("https://e2e-assessment.piton.com.tr"); // Uygulama sayfasını açıyorum
        ParametersWebDriver.getDriver().manage().window().maximize(); // sayfayı tam ekran yapıyorum
    }

    @When("The login form should appear") //Textin doğrulamasını yapıyorum
    public void theLoginFormShouldAppear() {
        lmp.findAndContainsText("loginForm", "Event Manager Login");
    }

    @Then("Contains username password and login button")
    public void containsUsernamePasswordAndLoginButton() {
        lmp.containElement("userName");  // Element var mı doğrulaması yapıyorum.
        lmp.containElement("password");
        lmp.containElement("loginButton");
    }

    @When("Click the login button")
    public void clickTheLoginButton() {
        lmp.findAndClick("loginButton"); // Elemente tıklama yapıyorum
    }

    @And("Validation errors should be displayed")
    public void validationErrorsShouldBeDisplayed() {
        lmp.findAndContainsText("userNameError", "Username field is required"); //Textin doğrulamasını yapıyorum
        lmp.findAndContainsText("passwordNameError", "Password field is required");
    }

    @When("Enter the username {string} and password {string} then click the login button") //{string} alanına "" içinde veri gönderebiliyorum parametre sırasına göre verileri alıyor.
    public void enterTheUsernameAndPasswordThenClickTheLoginButton(String userName, String password) {
        lmp.findAndSend("userName", userName); //Elemente veri gönderiyorum
        lmp.findAndSend("password", password);
        lmp.findAndClick("loginButton"); // Elemente tıklama yapıyorum
    }

    @And("Welcome message should be displayed") //Textin doğrulamasını yapıyorum
    public void welcomeMessageShouldBeDisplayed() {
        lmp.findAndContainsText("welcomeMessage","Welcome Automation Test User");
    }
}
