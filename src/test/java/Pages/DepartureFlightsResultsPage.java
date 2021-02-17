package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepartureFlightsResultsPage extends BasePage{

    @FindAll({@FindBy(id = "sortDropdown"),
            @FindBy(id = "listings-sort")})
    private WebElement sortByDropdown;
    @FindBy(css = "li[data-test-id='offer-listing']")
    private List<WebElement> allResultsList;

    public DepartureFlightsResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isThereASortByDropdown(){
        getCustomWait();
        if(sortByDropdown.isDisplayed()) {
            return true;
        }
        return false;
    }

    private boolean AllElementCard(List<WebElement> elements) {
        long countElementsNotEnabled = elements.stream().filter(a -> !a.isEnabled()).count();
        if(countElementsNotEnabled != 0) {
            return false;
        }
        if(elements.size() != allResultsList.size()) {
            return false;
        }
        return true;
    }



}
