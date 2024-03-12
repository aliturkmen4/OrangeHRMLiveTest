package StepDefinitions;

import Pages.LoginPage;
import Utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefinitons {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User at home page")
    public void userAtHomePage() {
        loginPage.userAtHome();
    }

    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Check {string} message about username and {string} message about password")
    public void checkMessageAboutUsernameAndMessageAboutPassword(String errormessage, String errormessage2) {
        loginPage.checkMessageAboutUsernameAndPassword(errormessage,errormessage2);
    }

}


