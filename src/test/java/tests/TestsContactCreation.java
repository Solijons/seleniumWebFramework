package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsContactCreation extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        int contactBefore = app.contact().allContactListSize();

        app.contact().initContactCreation();
        app.contact().fillOutContactForm(new ContactData()
                .withFirstName("Solijon")
                .withLastName("Sharipov")
                .withPhone("4243825880")
                .withEmail("solijon7762@gmail.com")
        );
        app.contact().submitCreation();
        app.contact().hideSideBar();
        int contactAfter = app.contact().allContactListSize();
        Assert.assertTrue(contactBefore < contactAfter);
    }

    @Test
    public void validateSaveButton() {
        app.goTo().homePage();
        app.contact().initContactCreation();
        Assert.assertTrue(app.contact().isSaveButtonDisabled());
    }

    @Test
    public void validateForm() {
        app.goTo().homePage();
        app.contact().initContactCreation();
        app.contact().fillOutContactForm(new ContactData()
                .withFirstName("")
                .withLastName("")
                .withPhone("23423dsfsdf")
                .withEmail("solijon7762")
        );

        app.contact().submitCreation();

        Assert.assertTrue(app.contact().isFirstNameErrorDisplayed());
        Assert.assertTrue(app.contact().isPhoneErrorDisplayed());
        Assert.assertTrue(app.contact().isEmailErrorDisplayed());
    }


}
