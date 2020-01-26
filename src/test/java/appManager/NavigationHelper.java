package appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private String UI_URL;

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goBackToHome() {
        click(By.linkText("Back to Dashboard"));
    }

    public void goToAddActivityPage() {
        click(By.id("ok"));
        click(By.xpath("//div[@id='scrollable-auto-tabpanel-0']/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/div/div/div/span/span[2]"));
        driver.navigate().to(UI_URL);
    }

    public void goToViewActivityPage() {
        driver.navigate().to("https://tractivity.breeding-np.ag/events/view?ids=133");
    }
}
