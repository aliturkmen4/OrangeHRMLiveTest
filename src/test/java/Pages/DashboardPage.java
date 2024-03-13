package Pages;

import Utils.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By myInfo=By.xpath("//span[normalize-space()='My Info']");

    By name=By.xpath("//input[@placeholder='First Name']");

    By lastName=By.xpath("//input[@placeholder='Last Name']");

    By saveButton=By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] button[type='submit']");

    By userNameArea=By.cssSelector(".oxd-userdropdown-name");

    public DashboardPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper=new ElementHelper(driver);
    }

    public void clickMyInfo() {
        driver.findElement(myInfo).click();
    }

    public void changeTheEmployeeNameAndSurname() {
        WebElement nameArea=driver.findElement(name);
        nameArea.click();
        nameArea.sendKeys(Keys.CONTROL+"a");
        nameArea.sendKeys(Keys.DELETE);
        nameArea.sendKeys("Ali");

        WebElement lastNameArea=driver.findElement(lastName);
        lastNameArea.click();
        lastNameArea.sendKeys(Keys.CONTROL+"a");
        lastNameArea.sendKeys(Keys.DELETE);
        lastNameArea.sendKeys("Turkmen");
    }

    public void saveTheChanges() {
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,350)");
        driver.findElement(saveButton).click();
    }


    public void checkTheUsernameArea() {
        driver.findElement(myInfo).click();
        WebElement username=driver.findElement(userNameArea);
        String usernameText=username.getText();
        Assert.assertEquals(usernameText,"Ali Turkmen");
    }
}
