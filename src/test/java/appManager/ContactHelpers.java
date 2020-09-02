package appManager;
import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactHelpers extends HelperBase {
    WebDriverWait wait = new WebDriverWait(driver, 5);

    public ContactHelpers(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        click(By.xpath("//button[@class='add-contact-btn float-btn']"));
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

    public int allContactListSize() {
        return driver.findElements(By.xpath("//div[@class='contact-name ng-binding']")).size();
    }

    public void hideSideBar() {
        click(By.xpath("//div[@class='back-btn']"));
    }


    public Boolean isSaveButtonDisabled() {
        String prop = driver.findElement(By
                .xpath("//button[@class='save-btn']"))
                .getAttribute("disabled");

        return Boolean.valueOf(prop);
    }

    public boolean isFirstNameErrorDisplayed() {
        return isElementPresent(By.xpath("//div[contains(text(),'First name is required.')]"));
    }

    public boolean isPhoneErrorDisplayed() {
        return isElementPresent(By.xpath("//div[contains(text(),'Wrong phone format.')]"));
    }

    public boolean isEmailErrorDisplayed() {
        return isElementPresent(By.xpath("//div[contains(text(),'Wrong email format.')]"));
    }




}
