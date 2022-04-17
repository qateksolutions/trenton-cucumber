package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");

    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public Home navigatingToHomePage() {
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }

    public NavigationBar mouseHoverToRates() {
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }

    public RealApr navigateToRealApr() {
        ActOn.element(driver, RealAprLink).click();
        return new RealApr(driver);
    }
}
