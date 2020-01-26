package appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    protected WebDriver driver;
    private String UI_URL;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void goBackToHome() {
        driver.findElement(By.linkText("Back to Dashboard")).click();
    }

    public void goToAddActivityPage() {
        driver.findElement(By.id("ok")).click();
        driver.findElement(By.xpath("//div[@id='scrollable-auto-tabpanel-0']/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/span[2]")).click();
        driver.navigate().to(UI_URL);
    }

    public void goToViewActivityPage() {
        driver.navigate().to("https://tractivity.breeding-np.ag/events/view?ids=133");
    }
}
