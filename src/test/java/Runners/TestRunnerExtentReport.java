package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
@CucumberOptions(
        tags = "@RegressionTest or @UnitTest", //Test edilecek senaryolar için tags belirledim.
        features = {"src/test/java/FeatureFiles"}, // buraya feature files in pathini girdim.
        glue = {"StepDefinitions"}, // Step definitions klasörünün adını girdim.
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber/cucumber.json"} //Extent test için plugin ekledim.
)
public class TestRunnerExtentReport extends AbstractTestNGCucumberTests {
    @AfterClass // Rapor bittiği zaman bu metodu çalıştırsın ve bilgileri eklesin
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name")); //Bilgisayar adını default ekler.
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone")); //Saat dilimini default ekler.
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name")); //İşletim sistemini default ekler.
        ExtentService.getInstance().setSystemInfo("Application Name", "Piton"); // Manuel bilgi ve açıklama eklemek için.
        ExtentService.getInstance().setSystemInfo("Department", "Test Birimi");
        ExtentService.getInstance().setSystemInfo("Team Leader", "Bilal");
        ExtentService.getInstance().setSystemInfo("Test Sorumlusu", "Bilal");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
    }
}
