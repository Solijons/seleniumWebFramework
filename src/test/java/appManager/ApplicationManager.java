package appManager;

import model.ActivityData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String UI_URL;

    protected void init() {
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

    public void goBackToHome() {
        driver.findElement(By.linkText("Back to Dashboard")).click();
    }

    public void closeModal() {
        driver.findElement(By.id("ok")).click();
    }

    public void submitActivityCreation() {
        driver.findElement(By.id("1579842872011")).click();
    }

    public void fillActivityForm(ActivityData activityData) {
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

    public void selectActivityType() {
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.cssSelector("button.MuiButtonBase-root.MuiFab-root.MuiFab-primary.MuiFab-sizeSmall > span.MuiFab-label > svg.MuiSvgIcon-root")).click();
    }

    public void goToAddActivityPage() {
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.xpath("//div[@id='scrollable-auto-tabpanel-0']/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/span[2]")).click();
        driver.navigate().to(UI_URL);
    }

    public void goToViewActivityPage() {
        driver.navigate().to("https://tractivity.breeding-np.ag/events/view?ids=133");
    }

    public void stop() {
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

    public void deleteActivity() {
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    }

    public void selectActivity() {
        driver.findElement(By.xpath("//div[@id='1576540800000']/div/div[2]/table/tbody/tr/td[7]/button[2]/i")).click();
    }
}

