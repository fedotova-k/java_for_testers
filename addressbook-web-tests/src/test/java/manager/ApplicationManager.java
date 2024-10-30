package manager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;

    public void init(String browser) {
        if (driver == null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/addressbook/");
            driver.findElement(By.name("user")).click();
            session().login("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public void createContact(ContactData contact) {
        openHomePage();
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys(contact.firstName());
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).click();
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).sendKeys(contact.middleName());
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).sendKeys(contact.lastName());
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }


    public void deleteContact() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }

    public void openHomePage() {
        if (!isElementPresent(By.name("home"))) {
            driver.findElement(By.linkText("home")).click();
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void openContactsPage() {
        if (!isElementPresent(By.name("submit"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    public boolean isContactPresent() {
        return isElementPresent(By.name("selected[]"));
    }
}