package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utiilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^a user is in mortgage calculator home page$")
    public void aUserIsInMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageUrl"));
        LOGGER.info("User is in the Mortgage Calculator Home page");
    }
    @Given("^user navigate to Real Apr page$")
    public void userNavigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
        LOGGER.info("Navigated to Real Apr Page");
    }

    @When("^user clicks on calculate button upon entering the data$")
    public void userClicksOnCalculateButtonUponEnteringTheData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            new RealApr(driver)
                    .enterHomePrice(cells.get("HomePrice"))
                    .selectDownPaymentInDollar()
                    .enterDownPayment(cells.get("DownPayment"))
                    .enterInterestRate(cells.get("InterestRate"))
                    .clickOnCalculateButton();
        }
        LOGGER.info("Real Apr rate is calculated upon entering the data");
    }
    @Then("^the real apr rate is \"(.+?)\"$")
    public void theRealAprRateIs(String realApr) {
        new RealApr(driver)
                .validateAprRate(realApr);
        LOGGER.info("Real Apr rate is validated");
    }

}
