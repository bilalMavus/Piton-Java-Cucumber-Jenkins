package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametersWebDriver {

    // Burada tüm sistemi static driver üzerine kurdum, threade özel static değişkenler oluşturdum.
    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>(); // Driver için thread oluşturdum.
    private static ThreadLocal<String> threadBrowserName=new ThreadLocal<>(); // Tarayıcılar için thread oluşturdum.

    public static WebDriver getDriver()
    {
        Locale.setDefault(new Locale("EN")); // Extend report da türkçe bilgi girilirse çalışması için eklendi
        System.setProperty("user.language", "EN"); // Extend report da türkçe bilgi girilirse çalışması için eklendi

        Logger.getLogger("").setLevel(Level.SEVERE); // Sisteme ait bütün logları üreten objeye/servise ulaştım ve "" yaptım. SEVERE seviyesinde hata alırsan gösteriyor diğer uyarı mesajlarını göstermiyor
        System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error"); // Konsolda slf4j yazılarını göstermemesi için ekledim.

        if (threadBrowserName.get() == null) // Paralel çalışmayan veya XLM den parametre gelmeyen her durum için default chrome tarayıcısı yap
            threadBrowserName.set("chrome"); // Chrome için default ayar yaptım

        if (threadDriver.get() == null) { // Threatdaki driver boş mu boş ise doldur.
            //Driveri start et doldur, başlat ve gönder işlemlerini aşağıda yaptım.
            switch (threadBrowserName.get()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver()); // Threade webdriver atadım.
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver()); // Threade webdriver atadım.
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver()); // Threade webdriver atadım.
                    break;
                default: // Herhangi bir parametre gelmediğinde de default çalışması için chromeyi defaulta atadım
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver()); // Threade webdriver atadım.
            }
        }

        return threadDriver.get(); //Bulunduğum thread deki drieri verecek
    }

    public static void quitDriver() //Driveri 3 sn bekletip kapatmak için kullanıyorum.
    {
        try {
            Thread.sleep(3000); // Bekletme süresi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null)  // Thread driver dolu ise
        {
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get(); driver =null; // Local threadı boşaltıp null'a eşitledim
            threadDriver.set(driver); // tekrar atama işlemi yaptım.
        }
    }

    public static void waits(int millis) //İşlemi 0.5 sn bekletmek için kullanıyorum.
    {
        try {
            Thread.sleep(millis); // Bekletme süresi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setThreadBrowserName(String browserName) { // Chrome harici brovserler için seti
        ParametersWebDriver.threadBrowserName.set(browserName);
    }

    public static String getThreadBrowserName() { // Chrome harici brovserler için geti
       return ParametersWebDriver.threadBrowserName.get();
    }

}
