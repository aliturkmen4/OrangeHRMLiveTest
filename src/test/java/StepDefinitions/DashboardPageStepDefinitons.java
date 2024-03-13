package StepDefinitions;

import Pages.DashboardPage;
import Utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DashboardPageStepDefinitons {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);


    @When("Click the My Info area")
    public void clickTheMyInfoArea() {
        dashboardPage.clickMyInfo();
    }

    @When("Change the employee name and surname")
    public void changeTheEmployeeNameAndSurname() {
        dashboardPage.changeTheEmployeeNameAndSurname();
    }

    @When("Save the changes")
    public void saveTheChanges() {
        dashboardPage.saveTheChanges();
    }

    @Then("Check the username area")
    public void checkTheUsernameArea() {
        dashboardPage.checkTheUsernameArea();
    }
}
