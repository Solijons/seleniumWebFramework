import model.ActivityData;
import org.testng.annotations.Test;

public class ActivityCreationTest extends TestBase {

    @Test
    public void testActivityCreation() throws Exception {
        // in case of error modal
        goToAddActivityPage();
        selectActivityType();
        fillActivityForm(new ActivityData("2020-01-23", "This is my test comment", "Ok"));
        submitActivityCreation();
        closeModal();
        goBackToHome();
    }

}
