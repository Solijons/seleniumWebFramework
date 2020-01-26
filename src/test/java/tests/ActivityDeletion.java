package tests;

import org.testng.annotations.Test;

public class ActivityDeletion extends TestBase {

    @Test
    public void testActivityDeletion() {
        app.goToViewActivityPage();
        app.selectActivity();
        app.deleteActivity();
        app.goBackToHome();
    }

}
