package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    By errorMessage=By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");

    By errorMessage2=By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");

    By loginCheck=By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title");

    By loginButton=By.cssSelector("button[type='submit']");

    By userName=By.cssSelector("input[placeholder='Username']");

    By password=By.cssSelector("input[placeholder='Password']");

    By errorMessage3=By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
     public LoginPage(WebDriver driver){
         this.driver=driver;
         this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
         this.elementHelper=new ElementHelper(driver);
     }
    public void userAtHome() {
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         WebElement title=driver.findElement(loginCheck);
         String loginTitle=title.getText();
         Assert.assertEquals(loginTitle,"Login");
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void checkMessageAboutUsernameAndPassword(String errormessage, String errormessage2) {
         driver.findElement(errorMessage).isDisplayed();
         driver.findElement(errorMessage2).isDisplayed();
    }

    public void writeFalseUsername(String username) {
        elementHelper.click(userName);
        elementHelper.sendKey(userName,"fdsfsdfsdfsdf");
    }

    public void writeFalsePassword(String passwordd) {
        elementHelper.click(password);
        elementHelper.sendKey(password,"fdsfsdfdfs");
    }

    public void checkMessageAboutFalseUsernameAndPassword(String error) {
         WebElement errorMessage=driver.findElement(errorMessage3);
         String errorMessageText=errorMessage.getText();
         Assert.assertEquals(errorMessageText,"Invalid credentials");
    }

    public void writeCorrectUsername(String username) {
        elementHelper.click(userName);
        elementHelper.sendKey(userName,"Admin");
    }

    public void writeCorrectPassword(String passwordd) {
        elementHelper.click(password);
        elementHelper.sendKey(password,"admin123");
    }

    public void checkTheUrlToUnderstandSuccessLogin() {
        String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
