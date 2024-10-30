package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class AddContactTest extends TestBase {

    @Test
    public void addContactTest() {
        app.contact().createContact(new ContactData().withFullName("SomeFirstName", "Some MiddleName", "SomeLastName"));
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
}
