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

    @FindAll({@FindBy(css = "option[value=\"duration:asc\"]"),
            @FindBy(css = "option[value=\"DURATION_INCREASING\"]")})
    private WebElement shortestDurationOption;

    @FindAll({
            @FindBy(xpath = "//li[1]//div[1]//div[2]//div[2]//div[1]//div[2]//button[1]"),
            @FindBy( css = "ol[data-test-id='listings'] li:nth-child(1)")}) //2
    private WebElement firstResult;

    @FindAll({
            @FindBy( xpath = "//li[3]//div[1]//div[2]//div[2]//div[1]//div[2]//button[1]"), //bn
            @FindBy( css = "ol[data-test-id='listings'] li:nth-child(3)")}) //perf
    private WebElement thirdResult;

    @FindAll({@FindBy(css = "#basic-economy-tray-content-1 > div > div > div.basic-economy-footer.uitk-grid.all-grid-align-end > button"),
            @FindBy(css = "div[data-test-id='details-and-fares-footer'] button[data-test-id='select-button']")})
    private WebElement selectFare;
    // #basic-economy-tray-content-1 > div > div > div.basic-economy-footer.uitk-grid.all-grid-align-end > button
    ////li[1]//div[2]//div[1]//div[1]//div[1]//div[1]//button[1]

    public DepartureFlightResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isThereASortByDropdown(){
        return isElementAvailable(sortByDropdown, 15);
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
        click(sortByDropdown, 15);
        click(shortestDurationOption);
    }

    public HomeSearchPage goToHome() {
        getDriver().get("https://www.travelocity.com/");
        return new HomeSearchPage(getDriver());
    }

    public void chooseFirstResult(){
        click(firstResult);
        click(selectFare, 15);
    }


}
