package appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {

    protected WebDriver driver;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private ActivityHelpers activityHelpers;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        activityHelpers = new ActivityHelpers(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);

        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("URL");

        sessionHelper.login("username", "passowrd");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public ActivityHelpers getActivityHelpers() {
        return activityHelpers;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}

