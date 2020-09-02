package appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {

    protected WebDriver driver;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private ContactHelpers contactHelpers;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        contactHelpers = new ContactHelpers(driver);
        sessionHelper = new SessionHelper(driver);

        baseUrl = "https://solijon-qa.oucampusdemo.com";
        navigationHelper = new NavigationHelper(driver, baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public ContactHelpers contact() {
        return contactHelpers;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}

