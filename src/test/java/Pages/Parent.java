package Pages;

import Utilities.ParametersWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utilities.ParametersWebDriver.getDriver;
import static org.testng.Assert.assertTrue;

public class Parent {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(getDriver());

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element); // Element gözükene kadar bekletiyorum.
        scrollToelement(element);  // javascriptexecuter ile elemente kadar scroll yaptırıyorum.
        element.clear();           // Elementin veri gireceği alan dolu ise temizliyor.
        element.sendKeys(value);   // Elemente değer gönderiyor.
    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element); // Tıklanabilir olana kadar bekletiyorum
        scrollToelement(element);    // javascriptexecuter ile elemente kadar scroll yaptırıyorum.
        element.click();             // Elemente tıklama işlemi yaptırıyorum.
    }

    public void waitUntilVisible(WebElement element) { // Element gözükene kadar bekletme işlemlerinde kullanıyorum.
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToelement(WebElement element) { // javascriptexecuter ile elemente kadar scroll yaptırma işlemlerinde kullanıyorum.
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilClickable(WebElement element) { // Tıklanabilir olana kadar bekletme işlemlerinde kullanıyorum.
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsTextFunction(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value)); // Doğrulama işlemleri için çalıştırıyorum beklenen koşulları ve bulunacak metin bekleniyor
        assertTrue(element.getText().contains(value), "The text you searched could'nt be find");
        new Actions(getDriver()).sendKeys(Keys.ESCAPE).perform(); // Açık dialog kutusu varsa kapatıyor.
    }

    public void doesItContainElement(WebElement element) {
        waitUntilVisible(element); // Element gözükene kadar bekletiyorum.
        assertTrue(element.isEnabled()); // Element var mı sorgusu yapıyorum
    }

    public void containsUrlFunction(WebElement element, String value) {
        waitUntilVisible(element); // Elementi görene kadar bekle
        assertTrue(getDriver().getCurrentUrl().contains(value), "The url you searched could'nt be find");
        new Actions(getDriver()).sendKeys(Keys.ESCAPE).perform(); // Açık dialog kutusu varsa kapatıyor.
    }

    public void TAB() {
        for (int i = 0; i < 10; i++) {
            new Actions(getDriver()).sendKeys(Keys.TAB).perform(); // Elementlerde gezinme
            ParametersWebDriver.waits(500);
        }
    }
}
