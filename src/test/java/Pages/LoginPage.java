package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    By errorMessage=By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");

    By errorMessage2=By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");

    By loginButton=By.cssSelector("button[type='submit']");
     public LoginPage(WebDriver driver){
         this.driver=driver;
         this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
         this.elementHelper=new ElementHelper(driver);
     }
    public void userAtHome() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void checkMessageAboutUsernameAndPassword(String errormessage, String errormessage2) {
         driver.findElement(errorMessage).isDisplayed();
         driver.findElement(errorMessage2).isDisplayed();
    }

}
