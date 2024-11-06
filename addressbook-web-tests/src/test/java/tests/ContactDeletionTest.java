package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletion() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData().withFirstName("test"));
        }
        int contactCount = app.contact().getCount();

        app.contact().deleteContact(app);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }
}


