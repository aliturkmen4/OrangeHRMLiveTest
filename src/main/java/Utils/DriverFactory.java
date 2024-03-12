package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver;

    static Properties properties;

    public static WebDriver initialize_Driver(String browser){
        properties=ConfigReader.getProperties();
        //Run.xml de geçilen browser değerine göre browser seçimi yapılıyor!
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        String url= properties.getProperty("url");
        int pageWait=Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        int impWait=Integer.parseInt(properties.getProperty("implicityWait"));
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWait));

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
