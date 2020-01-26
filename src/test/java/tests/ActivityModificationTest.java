package tests;

import model.ActivityData;
import org.testng.annotations.Test;

public class ActivityModificationTest extends TestBase{

    @Test
    public void testActivityModification () {
        app.getNavigationHelper().goToViewActivityPage();
        app.getActivityHelpers().selectActivity();
        app.getActivityHelpers().initModificationActivity();
        app.getActivityHelpers().fillActivityForm(new ActivityData("2020-01-23", "This is my test comment", "Ok"));
        app.getActivityHelpers().submitActivity();
    }

}
