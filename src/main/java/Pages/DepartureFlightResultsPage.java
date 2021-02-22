package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DepartureFlightResultsPage extends BasePage{

    @FindAll({@FindBy(id = "header-logo"),
            @FindBy(id = "a.header-logo")})
    private WebElement goToHome;

    @FindAll({@FindBy(id = "sortDropdown"),
            @FindBy(id = "listings-sort")})
    private WebElement sortByDropdown;

    @FindBy(css = "li[data-test-id='offer-listing']")
    private List<WebElement> allResultsList;

    @FindAll({@FindBy(css = ".display-larger-screens-only > button"),
            @FindBy(css = "button[data-test-id=\"select-link\"]")})
    private List<WebElement> selectionPossibility;

    @FindAll({@FindBy(css = "span[data-test-id='duration']"),
            @FindBy(css = "[data-test-id=\"journey-duration\"]")})
    private List<WebElement> duration;

    @FindAll({@FindBy(css = "a[data-test-id=\"flight-details-link\"]"),
            @FindBy(css = "li[data-test-id='offer-listing']")})
    private List<WebElement> flightDetailsAndBaggageFeesInfo;

    // #sortDropdown > option:nth-child(3)
    // option[value="duration:asc"]
    @FindAll({@FindBy(css = "option[value=\"duration:asc\"]"),
            @FindBy(css = "option[value=\"DURATION_INCREASING\"]")})
    private WebElement shortestDurationOption;
    // option[value="DURATION_INCREASING"]

//  button[data-offer-index="0"]
    @FindAll({
            @FindBy(css = "#flightModuleList > li:nth-child(1) > div > div[data-test-id=\"listing-summary\"] > div.all-col-shrink > div > div.all-col-shrink > button"),
            @FindBy(css = "#flightModuleList > li:nth-child(1) > div > div > div > button")})
    private WebElement firstResult;

    @FindAll({@FindBy(css = "#flightModuleList > li:nth-child(1) > div.basic-economy-tray > div > div > div > div > button"),
            @FindBy(css = "button[data-test-id=\"select-button\"]")})
    private WebElement selectFare;

    public DepartureFlightResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isThereASortByDropdown(){
        return isElementAvailable(sortByDropdown, getCustomWait().NORMAL_WAIT_SECONDS);
    }

    public boolean isSelectionPossibleForEveryResult() {
        return allResultsList.size() == selectionPossibility.size();
    }

    public boolean isDurationShownForEveryResult() {
        return allResultsList.size() == duration.size();
    }

    public boolean areFlightDetailsAndBaggageFeesAvailable(){
        isElementAvailable(sortByDropdown);
        return allResultsList.size() == flightDetailsAndBaggageFeesInfo.size();
    }

    public void selectSortByDuration(){
        click(sortByDropdown, getCustomWait().NORMAL_WAIT_SECONDS);
        log().info("It clicked on sort by dropdown menu.");
        click(shortestDurationOption, getCustomWait().NORMAL_WAIT_SECONDS);
        log().info("It sorted results by duration (shortest).");
    }

    public HomeSearchPage goToHome() {
        getDriver().get("https://www.travelocity.com/");
        return new HomeSearchPage(getDriver());
    }

    public ReturnFlightResultsPage chooseFirstResult(){

        click(firstResult, getCustomWait().NORMAL_WAIT_SECONDS);
        log().info("It chose the first option");
        click(selectFare, getCustomWait().NORMAL_WAIT_SECONDS);
        log().info("It selected the fare");
        return new ReturnFlightResultsPage(getDriver());
    }

}
