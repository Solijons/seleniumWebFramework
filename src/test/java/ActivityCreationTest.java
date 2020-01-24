import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ActivityCreationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://test.amp.monsanto.com/as/authorization.oauth2?response_type=code&client_id=BREEDING-IT-TPD-HAWAII-TRACTIVITY-UI&redirect_uri=https%3A%2F%2Ftractivity.breeding-np.ag%2Freceive-auth-token&state=aHR0cHM6Ly90cmFjdGl2aXR5LmJyZWVkaW5nLW5wLmFnLw%3D%3D&scope=openid%20profile%20fedHUB");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("gkqrl");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Betterblock_123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.xpath("//div[@id='scrollable-auto-tabpanel-0']/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/span[2]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.cssSelector("button.MuiButtonBase-root.MuiFab-root.MuiFab-primary.MuiFab-sizeSmall > span.MuiFab-label > svg.MuiSvgIcon-root")).click();
        driver.findElement(By.id("date")).click();
        driver.findElement(By.id("date")).clear();
        driver.findElement(By.id("date")).sendKeys("2020-01-23");
        driver.findElement(By.id("comments")).click();
        driver.findElement(By.id("comments")).clear();
        driver.findElement(By.id("comments")).sendKeys("This is my test comment");
        driver.findElement(By.id("status")).click();
        new Select(driver.findElement(By.id("status"))).selectByVisibleText("Ok");
        driver.findElement(By.xpath("(//input[@name='continuing'])[2]")).click();
        driver.findElement(By.id("1579842872011")).click();
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.linkText("Back to Dashboard")).click();
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
