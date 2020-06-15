package appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestHelpers extends HelperBase {
    public TestHelpers(WebDriver driver) {
        super(driver);
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public ArrayList<String> getYahooNavList() {
        ArrayList<String> links = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[@id='header-nav-bar']/li/a"));

        for (WebElement element: elementList) {
            links.add(element.getText());
        }

        return links;
    }

    public ArrayList<String> defaultYahooHeaderList() {
        ArrayList<String> links = new ArrayList<String>();
        links.add("Mail");
        links.add("Coronavirus");
        links.add("News");
        links.add("Finance");
        links.add("Sports");
        links.add("Politics");
        links.add("Black Lives Matter");
        links.add("Entertainment");
        links.add("Life");
        links.add("StayHome");
        links.add("Subscriptions");
        links.add("More...");
        return links;
    }

}
