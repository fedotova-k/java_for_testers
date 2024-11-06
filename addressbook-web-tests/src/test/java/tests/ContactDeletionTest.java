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

        app.contact().removeContact();
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    public void canRemoveAllContactsAtOnce() {
        if (app.contact().getCount()== 0) {
            app.contact().createContact(new ContactData().withFirstName("test"));
        }
        app.contact().removeAllContacts();
        Assertions.assertEquals(0, app.contact().getCount());
    }
}


