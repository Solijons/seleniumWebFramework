package tests;

import model.ContactData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestsContactCreation extends TestBase {

    @BeforeClass
    public void ensurePrecondition() {
        app.goTo().homePage();
        if (!app.contact().isThereContact()) {
            app.contact().createSampleData();
        }
    }

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        app.contact().initContactCreation();
        app.contact().fillOutContactForm(new ContactData()
                .withFirstName("Solijon")
                .withLastName("Sharipov")
                .withPhone("4243825880")
                .withEmail("solijon7762@gmail.com")
        );
        app.contact().submitCreation();
    }

}
