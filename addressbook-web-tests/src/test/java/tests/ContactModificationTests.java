package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData().withFullName("First name", "Middle name", "Last name"));
        }
        for (int i = 0; i <= app.contact().getCount(); i++) {
            app.contact().modifyContact(new ContactData().withFullName(randomString(i * 5), randomString(i), randomString(i*10)));
        }
    }
}