package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletion() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData().withFirstName("test"));
        }
        app.deleteContact();
    }
}


