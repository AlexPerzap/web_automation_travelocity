package Tests;

import Pages.DepartureFlightResultsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchResultsTests extends BaseTest{
    /*private DepartureFlightResultsPage departureFlightResultsPage;
    @BeforeMethod
    public DepartureFlightResultsPage selectDepartureAndReturnFlightFare(){
        return departureFlightResultsPage = searchForARoundTripFlightAndSortDepartureResults();
    }*/

    @Test
    public void ValidatePageContent(){
        DepartureFlightResultsPage departureFlightResultsPage
                = searchForARoundTripFlightAndSortDepartureResults();
        Assert.assertTrue(departureFlightResultsPage.isThereASortByDropdown(),"There is no a 'sort by' dropdown menu.");
        log().info("It has validated there is a 'sort by' dropdown menu.");
        Assert.assertTrue(departureFlightResultsPage.isSelectionPossibleForEveryResult(),"Selection option is not available for every result.");
        log().info("It has validated there is a selection option available for every result.");
        Assert.assertTrue(departureFlightResultsPage.isDurationShownForEveryResult(), "Duration is not shown for every result.");
        log().info("It has validated Duration is shown for every result.");
        Assert.assertTrue(departureFlightResultsPage.areFlightDetailsAndBaggageFeesAvailable(),
                "Flight details and baggage fees info is not available for every result.");
        log().info("It has validated flight details and baggage fees info is available for every result.");
        //departureFlightResultsPage.goToHome();
    }

}
