package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData().withFirstAndLastName("First name", "Last name"));
        }
        var oldContacts = app.contact().getList();
        var random = new Random();
        var index = random.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified first name");
        app.contact().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.contact().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index,testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}