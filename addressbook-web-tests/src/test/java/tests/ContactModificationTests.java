package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData().withFullName("First name", "Middle name", "Last name"));
        }
        app.contact().modifyContact(new ContactData().withFullName("modified First name", "modified Middle name", "modified last name"));
    }
}