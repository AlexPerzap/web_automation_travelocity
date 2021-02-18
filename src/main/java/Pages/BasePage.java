package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.CustomWait;

public abstract class BasePage {

    private CustomWait customWait = new CustomWait();
    private WebDriver driver;
    protected WebDriverWait wait;
    private Logger log = LoggerFactory.getLogger(BasePage.class);
    private static final int PERCENT = 100;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected CustomWait getCustomWait() {
        return customWait;
    }

    protected Logger log() {
        return log;
    }

    protected void goBack() {
        // driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.navigate()
                .back();
    }

    protected void click(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected void sendKeys(WebElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    protected boolean isElementAvailable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    protected boolean isElementAvailable(WebElement element, int seconds ) {
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    protected void switchToParentContent(){
        driver.switchTo().defaultContent();
    }

}
