package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeSearchPage extends BasePage{
    @FindBy(how = How.XPATH, using = "(//a[@href='?pwaLob=wizard-flight-pwa'])")
    private WebElement flightsSearchButton;
    @FindBy(how = How.CSS, using = "div#location-field-leg1-origin-menu>div>button")
    private WebElement leavingFromInput;
    @FindBy(how = How.CSS, using = "li:nth-child(1) > button")
    private WebElement firstOptionOnLeavingFrom;
    @FindBy(how = How.CSS, using = "button[data-stid = 'location-field-leg1-destination-menu-trigger']")
    private WebElement goingToInput;
    @FindBy(how = How.CSS, using = ".uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button")
    private WebElement firstOptionOnGoingTo;
    @FindBy(how = How.CSS, using = "button[data-testid='submit-button']")
    private WebElement searchButton;
    @FindBy(id = "d1-btn")
    private WebElement departingDateInput;
    @FindBy(how = How.CSS, using = "div:nth-of-type(2)>div>div:nth-of-type(2)>div>button:nth-of-type(2)")
    private WebElement monthsAheadCalendarButton;
    @FindBy(how = How.CSS, using = "button[aria-label*=' 1']:nth-of-type(1)")
    private WebElement date1;
    @FindBy(how = How.CSS, using = "button[aria-label*=' 10']:nth-of-type(1)")
    private WebElement date2;
    @FindBy(how = How.CSS, using = "div:nth-of-type(2)>div>div:nth-of-type(3)>button")
    private WebElement doneButton;

    public HomeSearchPage(WebDriver driver){
        super(driver);
    }

    public DepartureFlightResultsPage searchForARoundtripFlight(String leavingFrom, String goingTo){
        log().info("It clicks on Flights icon.");
        click(flightsSearchButton);
        log().info("It clicks on 'Leaving from' input and enters a departure airport.");
        sendKeys(leavingFromInput, leavingFrom);
        log().info("It chooses the first departure airport option.");
        click(firstOptionOnLeavingFrom);
        log().info("It clicks on 'Leaving from' input and enters a destination airport.");
        sendKeys(goingToInput, goingTo);
        log().info("It chooses the first 'Going to' airport option.");
        click(firstOptionOnGoingTo);
        log().info("It clicks on the departing date input and picks a departing and a returning date at least two months ahead.");
        click(departingDateInput);
        click(monthsAheadCalendarButton);
        click(monthsAheadCalendarButton);
        click(date1);
        click(date2);
        log().info("It clicks on the 'Done' button.");
        click(doneButton);
        log().info("It clicks on the 'Search' button and goes to results page.");
        click(searchButton);
        return new DepartureFlightResultsPage(getDriver());
    }

}


