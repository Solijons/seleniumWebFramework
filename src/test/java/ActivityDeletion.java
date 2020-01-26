import org.testng.annotations.Test;

public class ActivityDeletion extends TestBase {

    @Test
    public void testActivityDeletion() {
        goToViewActivityPage();
        selectActivity();
        deleteActivity();
        goBackToHome();

    }

}
