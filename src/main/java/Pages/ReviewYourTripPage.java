package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ReviewYourTripPage extends BasePage{
    public ReviewYourTripPage (WebDriver driver) {
        super(driver);
    }

    @FindAll({@FindBy(css = "header-logo"),
            @FindBy(css = "a.header-logo")})
    private WebElement goToHome;

}
