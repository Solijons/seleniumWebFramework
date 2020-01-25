import java.util.concurrent.TimeUnit;

import model.ActivityData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ActivityCreationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String UI_URL;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();

        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("URL");

        login("username", "passowrd");
    }

    private void login(String username, String passowrd) {
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(passowrd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testActivityCreation() throws Exception {
        // in case of error modal
        goToAddActivityPage();
        selectActivityType();
        fillActivityForm(new ActivityData("2020-01-23", "This is my test comment", "Ok"));
        submitActivityCreation();
        closeModal();
        backToHome();
    }

    private void backToHome() {
        driver.findElement(By.linkText("Back to Dashboard")).click();
    }

    private void closeModal() {
        driver.findElement(By.id("ok")).click();
    }

    private void submitActivityCreation() {
        driver.findElement(By.id("1579842872011")).click();
    }

    private void fillActivityForm(ActivityData activityData) {
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).clear();
        driver.findElement(By.id("date")).sendKeys(activityData.getDate());
        driver.findElement(By.id("comments")).click();
        driver.findElement(By.id("comments")).clear();
        driver.findElement(By.id("comments")).sendKeys(activityData.getComments());
        driver.findElement(By.id("status")).click();
        new Select(driver.findElement(By.id("status"))).selectByVisibleText(activityData.getStatus());
        driver.findElement(By.xpath("(//input[@name='continuing'])[2]")).click();
    }

    private void selectActivityType() {
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.cssSelector("button.MuiButtonBase-root.MuiFab-root.MuiFab-primary.MuiFab-sizeSmall > span.MuiFab-label > svg.MuiSvgIcon-root")).click();
    }

    private void goToAddActivityPage() {
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.xpath("//div[@id='scrollable-auto-tabpanel-0']/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/span[2]")).click();
        driver.navigate().to(UI_URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
