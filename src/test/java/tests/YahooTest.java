package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class YahooTest extends TestBase {

    @Test
    public void testYahooHomePageLinks() throws Exception {
        app.goTo().yahooHomePage();
        app.test().fullScreen();
        ArrayList<String> actualLinks = app.test().getYahooNavList();
        ArrayList<String> expectedLinks = app.test().defaultYahooHeaderList();

        System.out.println("Expected list " + expectedLinks);
        System.out.println("Actual list " + actualLinks);

        int tmp;
        Assert.assertEquals(actualLinks.size(), expectedLinks.size());
        for (String headerLink: actualLinks) {
            Assert.assertTrue(expectedLinks.contains(headerLink));
            tmp = expectedLinks.indexOf(headerLink);
            expectedLinks.remove(tmp);
        }


    }

}
