package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class AddContactTest extends TestBase {

    @Test
    public void addContactTest() {
        app.openContactsPage();
        app.createContact(new ContactData().withFullName("SomeFirstName", "Some MiddleName", "SomeLastName"));
    }

    @Test
    public void addContactTestWithEmptyNames() {
        app.openContactsPage();
        app.createContact(new ContactData());
    }
    @Test
    public void addContactWithFirstNameOnly() {
       app.openContactsPage();
        app.createContact(new ContactData().withFirstName("some First name"));
    }
    @Test
    public void addContactWithNameCompanyEmail() {
       app.openContactsPage();
        app.createContact(new ContactData().withAllData("Test first name", "Test middle name", "Test last name", "Some company", "some email"));
    }
}
