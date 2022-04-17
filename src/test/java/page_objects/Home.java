package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private final By HomeValue = By.id("homeval");
    private final By DownPaymentInDollar = By.name("param[downpayment_type]");
    private final By DownPayment = By.id("downpayment");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm =  By.id("loanterm");
    private final By StartMonth = By.name("param[start_month]");
    private final By StartYear = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HOI = By.id("hoi");
    private final By HOA = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By BuyOrRefi = By.name("param[refiorbuy]");
    private final By Calculate = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver) {
        super(driver);
    }

    public Home enterHomeValue(String value) {
        LOGGER.debug("Enter the home value: " + value);
        ActOn.element(driver, HomeValue).setValue(value);
        return this;
    }

    public Home clickOnDollarSign() {
        LOGGER.debug("Click on the $ radio button option");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public Home enterDownPayment(String value) {
        LOGGER.debug("Enter the down payment value: " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    public Home enterInterestRate(String value) {
        LOGGER.debug("Enter the interest rate value: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    public Home enterLoanTerm(String value) {
        LOGGER.debug("Enter the loan term value: " + value);
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;
    }

    public Home selectStartMonth(String value) {
        LOGGER.debug("Select the start month: " + value);
        ActOn.element(driver, StartMonth).selectValue(value);
        return this;
    }

    public Home enterStartYear(String value) {
        LOGGER.debug("Enter the Start Year value: " + value);
        ActOn.element(driver, StartYear).setValue(value);
        return this;
    }

    public Home enterPropertyTax(String value) {
        LOGGER.debug("Enter the Property tax value: " + value);
        ActOn.element(driver, PropertyTax).setValue(value);
        return this;
    }

    public Home enterPMI(String value) {
        LOGGER.debug("Enter the PMI value: " + value);
        ActOn.element(driver, PMI).setValue(value);
        return this;
    }

    public Home enterHOI(String value) {
        LOGGER.debug("Enter the Home Insurance value: " + value);
        ActOn.element(driver, HOI).setValue(value);
        return this;
    }

    public Home enterHOA(String value) {
        LOGGER.debug("Enter the HOA value: " + value);
        ActOn.element(driver, HOA).setValue(value);
        return this;
    }

    public Home selectLoanType(String value) {
        LOGGER.debug("Select the loan type value: " + value);
        ActOn.element(driver, LoanType).selectValue(value);
        return this;
    }

    public Home selectBuyOrRefinance(String value) {
        LOGGER.debug("Select Buy Or Refinance value: " + value);
        ActOn.element(driver, BuyOrRefi).selectValue(value);
        return this;
    }

    public Home clickOnCalculate() {
        LOGGER.debug("Clicking on Calculate Button");
        ActOn.element(driver, Calculate).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String expectedMonthlyPayment) {
        LOGGER.debug("Validate Total Monthly Payment is Displayed: " + expectedMonthlyPayment);
        By TotalMonthlyPayment = By.xpath("//h3[text()='$" + expectedMonthlyPayment + "']");
        AssertThat.elementAssertions(driver, TotalMonthlyPayment).elementIsDisplayed();
        return this;
    }
}
