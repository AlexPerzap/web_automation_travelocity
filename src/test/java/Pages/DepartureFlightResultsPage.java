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
        //return isEveryWebElementOnThisListAvailable(duration);
        return allResultsList.size() == duration.size();

    }

    public boolean areFlightDetailsAndBaggageFeesAvailable(){
        isElementAvailable(sortByDropdown);
        return allResultsList.size() == flightDetailsAndBaggageFeesInfo.size();
    }

    public void selectSortByDuration(){
        click(sortByDropdown);
        click(shortestDurationOption);
    }

    public HomeSearchPage goToHome() {
        getDriver().get("https://www.travelocity.com/");
        return new HomeSearchPage(getDriver());
    }


    /*private Select findDropDownElement(){
        return new Select(getDriver()));
    }

    public void sortResultsByShorter(){
        click(sortByDropdown);
    }*/

}
