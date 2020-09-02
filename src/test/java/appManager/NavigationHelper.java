package appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private String UI_URL;

    public NavigationHelper(WebDriver driver, String baseUrl) {
        super(driver);
        this.UI_URL = baseUrl;
    }

    public void homePage() {
        driver.get(UI_URL);
    }

}
