package tests;

import model.ActivityData;
import org.testng.annotations.Test;

public class ActivityCreationTest extends TestBase {

    @Test
    public void testActivityCreation() throws Exception {
        // in case of error modal
        app.getNavigationHelper().goToAddActivityPage();
        app.getActivityHelpers().selectActivityType();
        app.getActivityHelpers().fillActivityForm(new ActivityData("2020-01-23", "This is my test comment", "Ok"));
        app.getActivityHelpers().submitActivity();
        app.getActivityHelpers().closeModal();
        app.getNavigationHelper().goBackToHome();
    }

}
