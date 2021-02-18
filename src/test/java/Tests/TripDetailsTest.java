package Tests;

import Pages.DepartureFlightResultsPage;
import org.testng.annotations.*;

public class TripDetailsTest extends BaseTest{

    @Test
    public void ValidateTripDetails(){
        DepartureFlightResultsPage departureFlightResultsPage
                = searchForARoundTripFlightAndSortDepartureResults();
        departureFlightResultsPage.chooseFirstResult();

    }

}
