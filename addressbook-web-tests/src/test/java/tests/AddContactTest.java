package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class AddContactTest extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "First name")) {
            for (var middleName : List.of("", "middle name")) {
                for (var lastName : List.of("", "last Name")) {
                    for (var address : List.of("", "some address")) {
                        for (var email : List.of("", "email")) {
                            result.add(new ContactData(firstName, middleName, lastName, address, email));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            result.add(new ContactData(randomString(i * 5), randomString(i * 5), randomString(i * 5), randomString(i * 6), randomString(i * 4)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createMultipleContacts(ContactData contact) {
        int ContactCount = app.contact().getCount();

        app.contact().createContact(contact);

        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(ContactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("first name' ", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contact().getCount();

        app.contact().createContact(contact);

        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
