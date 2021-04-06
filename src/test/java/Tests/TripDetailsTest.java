package Tests;

import Pages.DepartureFlightResultsPage;
import Pages.ReturnFlightResultsPage;
import org.testng.annotations.*;

public class TripDetailsTest extends BaseTest{

    @Test
    public void ValidateTripDetails(){
        DepartureFlightResultsPage departureFlightResultsPage
                = searchForARoundTripFlightAndSortDepartureResults();
        ReturnFlightResultsPage returnFlightResultsPage = departureFlightResultsPage.chooseFirstResult();
        returnFlightResultsPage.chooseThirdResult();
    }
}
