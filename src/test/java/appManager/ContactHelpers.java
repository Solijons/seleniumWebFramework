package appManager;
import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactHelpers extends HelperBase {
    public ContactHelpers(WebDriver driver) {
        super(driver);
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void initContactCreation() {
        click(By.xpath("//button[@class='add-contact-btn float-btn']"));
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.name("firstName")))
        ).isDisplayed();
    }

    public void fillOutContactForm(ContactData contactData) {
        type(By.name("firstName"), contactData.getFirstName());
        type(By.xpath("//input[@placeholder='Last Name']"), contactData.getLastName());
        type(By.name("phone"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
    }

    public void submitCreation() {
        click(By.xpath("//button[@class='save-btn']"));
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("//div[@class='empty-text']"));
    }

    public void createSampleData() {
        click(By.xpath("//span[contains(text(),'Create sample data?')]"));
    }
}
