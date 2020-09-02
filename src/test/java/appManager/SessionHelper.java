package appManager;

import model.IAM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(IAM data) {
        type(By.id("username"), data.getUsername());
        type(By.id("password"), data.getPassword());
        click(By.xpath("//button[@type='submit']"));
    }
}
