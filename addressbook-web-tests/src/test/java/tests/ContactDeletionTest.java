package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletion() {

        app.openHomePage();//перенести в метод

        if (!app.isContactPresent()) {
            app.createContact(new ContactData().withFirstName("test"));
        }
        app.deleteContact();
    }
}


