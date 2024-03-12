package StepDefinitions;

import Pages.LoginPage;
import Utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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

    @When("Write false {string} for username field")
    public void writeFalseForUsernameField(String username) {
        loginPage.writeFalseUsername(username);
    }

    @When("Write false {string} for password field")
    public void writeFalseForPasswordField(String password) {
        loginPage.writeFalsePassword(password);
    }

    @Then("Check {string} message about false username and false password")
    public void checkMessageAboutFalseUsernameAndFalsePassword(String error) {
        loginPage.checkMessageAboutFalseUsernameAndPassword(error);
    }

    @When("Write correct {string} for username field")
    public void writeCorrectForUsernameField(String username) {
        loginPage.writeCorrectUsername(username);
    }

    @When("Write correct {string} for password field")
    public void writeCorrectForPasswordField(String password) {
        loginPage.writeCorrectPassword(password);
    }

    @Then("Check the url to understand success login")
    public void checkTheUrlToUnderstandSuccessLogin() {
        loginPage.checkTheUrlToUnderstandSuccessLogin();
    }
}


