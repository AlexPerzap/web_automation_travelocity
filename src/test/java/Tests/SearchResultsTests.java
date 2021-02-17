package Tests;

import Pages.DepartureFlightsResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends BaseTest{

    @Test
    public void ValidateResultsPageContent(){
        log().info("ValidateResultsPageContent test begins.");
        DepartureFlightsResultsPage departureFlightsResultsPage =
                getHomeSearchPage().searchForARoundtripFlight("LAS", "LAX");
        Assert.assertTrue(departureFlightsResultsPage.isThereASortByDropdown(),
                "There is no a 'sort by' dropdown menu.");
        log().info("It has validated there is a 'sort by' dropdown menu.");


    }
}
