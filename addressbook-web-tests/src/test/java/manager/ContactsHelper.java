package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        click(By.name("submit"));
        openHomePage(manager);
    }

    public void deleteContact(ApplicationManager manager) {
        click(By.name("selected[]"));
        click(By.xpath("//input[@value=\'Delete\']"));
        manager.contact().openHomePage(manager);
    }

    public void openHomePage(ApplicationManager manager) {
        if (!manager.isElementPresent(By.name("home"))) {
            click(By.linkText("home"));
        }
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            click(By.linkText("add new"));
        }
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    public void modifyContact(ContactData modifiedContact) {
        openHomePage(manager);
        selectContact();
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        openHomePage(manager);
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
    }

    public int getCount() {
        openHomePage(manager);
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openHomePage(manager);
        selectAllContacts();
        deleteContact(manager);
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
