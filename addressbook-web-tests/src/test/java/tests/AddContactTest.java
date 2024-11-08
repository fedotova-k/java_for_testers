package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddContactTest extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "First name")) {
            for (var lastName : List.of("", "last Name")) {
                result.add(new ContactData().withFirstAndLastName(firstName, lastName));
            }
        }

        for (int i = 0; i < 10; i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i * 5))
                    .withMiddleName(randomString(i * 5))
                    .withLastName(randomString(i * 5)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")

    public void createMultipleContacts(ContactData contact) {
        var oldContact = app.contact().getList();

        app.contact().createContact(contact);

        var newContacts = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContact);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withFirstName(contact.firstName()).withLastName(contact.lastName()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }

    public static List<ContactData> negativeContactProvider() {

        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "first name' ", "", "")));
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


