package Tests;

import Pages.BasePage;
import Pages.HomeSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public abstract class BaseTest {
    private HomeSearchPage homeSearchPage;
    private static WebDriver driver;
    private Logger log = LoggerFactory.getLogger(BasePage.class);

    @BeforeClass
    @Parameters({"browser"})
    protected void setupClass(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                clearBrowserData();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                clearBrowserData();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                clearBrowserData();
                break;
        }

        driver.get("https://www.travelocity.com");
        driver.manage().window().maximize();
        homeSearchPage = new HomeSearchPage(driver);
    }

    protected void clearBrowserData(){
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }

    protected Logger log() {
        return log;
    }

    public HomeSearchPage getHomeSearchPage() {
        return homeSearchPage;
    }

   /*@AfterClass
    protected void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
