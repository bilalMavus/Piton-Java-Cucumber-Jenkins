package StepDefinitions;

import Pages.DashboardModulePage;
import Pages.LoginModulePage;
import Pages.EventModulePage;
import Pages.Parent;
import Utilities.ParametersWebDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static Utilities.ParametersWebDriver.getDriver;

public class DashboardModuleSteps {
    DashboardModulePage dmp = new DashboardModulePage();
    EventModulePage emp = new EventModulePage();
    LoginModulePage lmp = new LoginModulePage();
    Parent parent = new Parent();

    @Given("Navigate to url {string}")
    public void navigateToUrl(String url) {
        ParametersWebDriver.getDriver().get(url); // Uygulama sayfasını açıyorum
        ParametersWebDriver.getDriver().manage().window().maximize(); // sayfayı tam ekran yapıyorum
    }

    @Then("View dashboard if url is correct {string}") // Url Doğrulaması yaptım
    public void viewDashboardIfUrlIsCorrect(String url) {
        dmp.containUrl("eventText", url);
    }

    @Then("View login if url is correct {string}")// Url Doğrulaması yaptım.
    public void viewLoginIfUrlIsCorrect(String url) {
        dmp.containUrl("loginForm", url);
    }

    @Then("No registered event found message") // Mesaj doğrulaması yaptım.
    public void noRegisteredEventFoundMessage() {
        dmp.findAndContainsText("noRegistrationMessage", "No registered event has been found!!");
    }

    @Given("Logging in and creating event and edit") // Edit işlemine kadar tek metod yaptım.
    public void loggingInAndCreatingEventAndEdit() {
        ParametersWebDriver.getDriver().get("https://e2e-assessment.piton.com.tr");
        ParametersWebDriver.getDriver().manage().window().maximize();
        lmp.findAndSend("userName", "automationtest");
        lmp.findAndSend("password", "123456789");
        lmp.findAndClick("loginButton");
        emp.findAndClick("createEvent");
        emp.findAndSend("eventName", "Test Event");
        emp.findAndSend("eventDescription", "Everything about the test");
        emp.findAndClick("dateClick");
        emp.findAndClick("nextMonthClick");
        emp.findAndClick("dayClick");
        emp.findAndSend("firstName", "Test");
        emp.findAndSend("lastName", "Uzmanı");
        emp.findAndSend("contact", "test@piton.com.tr");
        emp.findAndClick("eventButton");
        emp.findAndClick("editButton");
    }

    @When("TAB the edit elements") // Tab tuşu ile adımlamayı yaptım
    public void tabTheEditElements() {
        parent.TAB();
    }

    @Given("Logging in and creating event") // Tek metod ile evet oluşturdum
    public void loggingInAndCreatingEvent() {
        ParametersWebDriver.getDriver().get("https://e2e-assessment.piton.com.tr");
        ParametersWebDriver.getDriver().manage().window().maximize();
        lmp.findAndSend("userName", "automationtest");
        lmp.findAndSend("password", "123456789");
        lmp.findAndClick("loginButton");
        emp.findAndClick("createEvent");
        emp.findAndSend("eventName", "New Year");
        emp.findAndSend("eventDescription", "New year celebration");
        emp.findAndClick("dateClick");
        emp.findAndClick("nextMonthClick");
        emp.findAndClick("dayClick");
        emp.findAndSend("firstName", "Test");
        emp.findAndSend("lastName", "Uzmanı");
        emp.findAndSend("contact", "test@piton.com.tr");
        emp.findAndClick("eventButton");
    }

    @When("Click the delete button and delete it") // Event sildim
    public void clickTheDeleteButtonAndDeleteIt() {
        emp.findAndClick("deleteButton");
    }

    @Given("Signing in")// Login işlemi yaptım
    public void signingInToCreateAnEvent(DataTable value) { //DataTable kullanımı için yaptım
        List<List<String>> listElemanlar = value.asLists(String.class); // Gelen değerleri 2D listeye atıyorum.
        for (int i = 0; i < listElemanlar.size(); i++)
            lmp.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1)); //1. turda elementin adı, 2. turda textini alıyorum ve doğrulamaya gönderiyorum.
    }

    @When("Creating event and entering participants") // Login yapıldıktan sonra tek metod ile event oluşturdum
    public void creatingEventAndEnteringParticipants() {
        emp.findAndSend("eventName", "New Year");
        emp.findAndSend("eventDescription", "New year celebration");
        emp.findAndClick("dateClick");
        emp.findAndClick("nextMonthClick");
        emp.findAndClick("dayClick");
        emp.findAndSend("firstName", "Test");
        emp.findAndSend("lastName", "Uzmanı");
        emp.findAndSend("contact", "test@piton.com.tr");
        emp.findAndClick("eventButton");
    }

    @Given("Navigate to urls") // Url girişi yapmak için kullandım
    public void navigateToUrls(String url) {
        ParametersWebDriver.getDriver().get(url);
        ParametersWebDriver.getDriver().manage().window().maximize();
    }

    @And("Click on the button") // Buton tıklamaları için kullandım
    public void clickOnTheButton(DataTable value) { //DataTable kullanımı için yaptım
        List<String> listElemanlar = value.asList(String.class); // Gelen değerleri listeye atıyorum.
        for (String strButtonName : listElemanlar) {
            emp.findAndClick(strButtonName);  // Listeden gelen elementlere tıklama işlemi yapıyorum
        }
    }

    @Then("Random generating {int} participants") // İstediğim kadar katılımcı girişi yapmak için metod yaptım.
    public void randomGeneratingParticipants(int element) {
        int a = 5;
        for (int i = 1; i < (element + 1); i++) {
            String randomKelime1 = RandomStringUtils.randomAlphanumeric(5);
            String randomKelime2 = RandomStringUtils.randomAlphanumeric(8);
            String randomKelime3 = RandomStringUtils.randomAlphanumeric(10);
            emp.findAndClick("editButton");
            emp.findAndClick("addParticipant");
            if (i != 1)
                a = a + 4;
            for (int j = 0; j < a; j++) {
                new Actions(getDriver()).sendKeys(Keys.TAB).perform();
                ParametersWebDriver.waits(100);
            }
            new Actions(getDriver()).sendKeys(randomKelime1).perform();
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
            new Actions(getDriver()).sendKeys(randomKelime2).perform();
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
            new Actions(getDriver()).sendKeys(randomKelime3 + "@piton.com.tr").perform();
            emp.findAndClick("updateEventButton");
        }
    }

    @And("The event participant list visible") //katılımcı listesine tıklama işlemi
    public void theEventParticipantListVisible() {
        dmp.findAndClick("participantListClick");
    }

    @And("Is the event participant list visible") // katılımcı listesini doğrulama işlemi
    public void isTheEventParticipantListVisible() {
        dmp.findAndContainsText("participantList","Participiants Of");
    }

}