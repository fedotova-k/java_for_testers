package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactsHelper {

    private final ApplicationManager manager;

    public ContactsHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middleName());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastName());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.name("submit"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }
}
