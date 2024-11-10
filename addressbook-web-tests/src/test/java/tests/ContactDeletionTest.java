package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletion() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData("", "first name", "", ""));
        }
        var oldContacts = app.contact().getList();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.contact().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
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


