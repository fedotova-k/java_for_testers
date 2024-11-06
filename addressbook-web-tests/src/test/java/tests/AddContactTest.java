package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddContactTest extends TestBase {

    @Test
    public void addContactTest() {
        int contactCount = app.contact().getCount();
        app.contact().createContact(new ContactData().withFullName("SomeFirstName", "Some MiddleName", "SomeLastName"));
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount +1, newContactCount);
    }

    @Test
    public void addContactTestWithEmptyNames() {
        app.contact().createContact(new ContactData());
    }

    @Test
    public void addContactWithFirstNameOnly() {
        app.contact().createContact(new ContactData().withFirstName("some First name"));
    }

    @Test
    public void addContactWithNameCompanyEmail() {
        app.contact().createContact(new ContactData().withAllData("Test first name", "Test middle name", "Test last name", "Some company", "some email"));
    }
    @Test
    public void createMultipleContacts() {
        int n = 5;
        int ContactCount = app.contact().getCount();

        for (int i = 0; i < n; i++) {
            app.contact().createContact(new ContactData().withFullName(randomString(i * 5), randomString(i), randomString(i*10)));
        }
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(ContactCount + n, newContactCount);
    }
}
