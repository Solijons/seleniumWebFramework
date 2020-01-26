package appManager;

import model.ActivityData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActivityHelpers {

    protected WebDriver driver;

    public ActivityHelpers(WebDriver driver) {
        this.driver = driver;
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

    public void deleteActivity() {
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    }

    public void selectActivity() {
        driver.findElement(By.xpath("//div[@id='1576540800000']/div/div[2]/table/tbody/tr/td[7]/button[2]/i")).click();
    }
}
