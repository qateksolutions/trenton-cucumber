package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar {
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab =  By.xpath("//label[text()='Calculator']");
    private final By HomePrice = By.name("HomeValue");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By DownPayment = By.name("DownPayment");
    private final By InterestRate = By.name("Interest");
    private final By Calculate = By.name("calculate");
    private final By ActualApr = By.xpath("//table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver) {
        super(driver);
    }

    public RealApr waitForPageToLoad() {
        LOGGER.debug("Wait for the Real Apr page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }

    public RealApr enterHomePrice(String value) {
        LOGGER.debug("Enter Home Price: " + value);
        ActOn.element(driver, HomePrice).setValue(value);
        return this;
    }

    public RealApr selectDownPaymentInDollar() {
        LOGGER.debug("Click on the $ for down payment");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealApr enterDownPayment(String value) {
        LOGGER.debug("Enter Down payment: " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    public RealApr enterInterestRate(String value) {
        LOGGER.debug("Enter the interest rate: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    public RealApr clickOnCalculateButton() {
        LOGGER.debug("click on the calculate button");
        ActOn.element(driver, Calculate).click();
        return this;
    }

    public RealApr validateAprRate(String expectedRate) {
        LOGGER.debug("Validating the Actual Apr Rate is: " + expectedRate);
        String actualAprValue = ActOn.element(driver, ActualApr).getTextValue();
        Assert.assertEquals(expectedRate, actualAprValue);
        return this;
    }
}
