package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
    // time in seconds for waits methods.
    public final long MIN_WAIT_SECONDS = 1;
    public final long SHORT_WAIT_SECONDS = 5;
    public final long NORMAL_WAIT_SECONDS = 15;
    public final long MEDIUM_WAIT_SECONDS = 40;
    public final long LARGE_WAIT_SECONDS = 60;
    private static final int SECONDS_CONVERSION = 1000;


    public void waitWebElementVisibility(WebDriver driver, WebElement Element,
                                         long waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void waitWebElementInvisibility(WebDriver driver, WebElement Element,
                                               long waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.invisibilityOf(Element));
    }

    public void waitAndroidElementToBeClickable(WebDriver driver, WebElement Element,
                                                long waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(Element));
    }

    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * SECONDS_CONVERSION);
        } catch (InterruptedException ex) {
            Thread.currentThread()
                    .interrupt();
        }
    }

    public void clickAfterWaiting(WebDriver driver, WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
