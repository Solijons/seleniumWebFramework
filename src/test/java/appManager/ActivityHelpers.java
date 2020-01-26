package appManager;

import model.ActivityData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActivityHelpers extends HelperBase {

    public ActivityHelpers(WebDriver driver) {
        super(driver);
    }

    public void closeModal() {
        click(By.id("ok"));
    }

    public void submitActivity() {
        click(By.name("submitNFEEvent"));
    }

    public void fillActivityForm(ActivityData activityData) {
        type(By.id("date"), activityData.getDate());
        type(By.id("comments"), activityData.getComments());
        click(By.id("status"));
        new Select(driver.findElement(By.id("status"))).selectByVisibleText(activityData.getStatus());
        click(By.xpath("(//input[@name='continuing'])[2]"));
    }

    public void selectActivityType() {
        click(By.xpath("(//button[@type='button'])[2]"));
        click(By.cssSelector("button.MuiButtonBase-root.MuiFab-root.MuiFab-primary.MuiFab-sizeSmall > span.MuiFab-label > svg.MuiSvgIcon-root"));
    }

    public void deleteActivity() {
        click(By.xpath("(//button[@type='button'])[8]"));
    }

    public void selectActivity() {
        click(By.xpath("//div[@id='1576540800000']/div/div[2]/table/tbody/tr/td[7]/button[2]/i"));
    }

    public void initModificationActivity() {
        click(By.xpath("//button[@id='1035']/i"));
    }

}
