package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ApplicationManager manager) {
        super (manager);
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        type (By.name ("firstname"), contact.firstName());
        type(By.name ("middlename"), contact.middleName());
        type(By.name ("lastname"), contact.lastName());
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

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }
}
