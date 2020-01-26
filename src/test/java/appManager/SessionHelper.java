package appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String passowrd) {
        type(By.id("username"), username);
        type(By.id("password"), passowrd);
        click(By.xpath("//button[@type='submit']"));
    }
}
