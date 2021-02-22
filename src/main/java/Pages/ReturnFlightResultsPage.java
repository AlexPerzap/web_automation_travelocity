package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ReturnFlightResultsPage extends BasePage{

    public ReturnFlightResultsPage (WebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(css = "header-logo"),
            @FindBy(css = "a.header-logo")})
    private WebElement goToHome;

    //button[data-offer-index="2"]
    @FindAll({
            @FindBy( css = "#flightModuleList > li:nth-child(3) > div > div[data-test-id=\"listing-summary\"] > div.all-col-shrink > div > div.all-col-shrink > button\n"),
            @FindBy( css = "#flightModuleList > li:nth-child(3) > div > div > div > button")})
    private WebElement thirdResult;

    @FindAll({@FindBy(css = "#flightModuleList > li:nth-child(3) > div.basic-economy-tray > div > div > div > div > button"),
            @FindBy(css = "button[data-test-id=\"select-button\"]")})
    private WebElement selectFare;

    @FindAll({
            @FindBy( css = "#forcedChoiceNoThanks"),
            @FindBy( css = "a[data-test-id=\"forcedChoiceNoThanks\"]")})
    private WebElement noThanksOnModal;


    public ReviewYourTripPage chooseThirdResult(){
        log().info("It came to ReturnFlightResultsPage");
        click(thirdResult, getCustomWait().NORMAL_WAIT_SECONDS);
        log().info("It chose the third option");
        click(selectFare, getCustomWait().NORMAL_WAIT_SECONDS);
        log().info("It selected the fare");
        if (isElementAvailable(noThanksOnModal)){
            click(noThanksOnModal, getCustomWait().NORMAL_WAIT_SECONDS);
            log().info("It clicked on 'No Thanks'");
        }
        return new ReviewYourTripPage(getDriver());
    }
}
