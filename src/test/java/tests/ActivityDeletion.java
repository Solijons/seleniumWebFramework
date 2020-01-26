package tests;

import org.testng.annotations.Test;

public class ActivityDeletion extends TestBase {

    @Test
    public void testActivityDeletion() {
        app.getNavigationHelper().goToViewActivityPage();
        app.getActivityHelpers().selectActivity();
        app.getActivityHelpers().deleteActivity();
        app.getNavigationHelper().goBackToHome();
    }

}
