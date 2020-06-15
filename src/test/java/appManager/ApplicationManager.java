package appManager;

import model.UserData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {

    protected WebDriver driver;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private TestHelpers TestHelpers;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        TestHelpers = new TestHelpers(driver);
        sessionHelper = new SessionHelper(driver);

        baseUrl = "https://www.yahoo.com/";
        navigationHelper = new NavigationHelper(driver, baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // sessionHelper.login(new UserData().withUsername("username").withPassword("password"));
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    public TestHelpers test() {
        return TestHelpers;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}

