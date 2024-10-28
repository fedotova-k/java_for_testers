package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactDeletionTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));

            driver.get("http://localhost/addressbook/addressbook/");
            driver.findElement(By.xpath("//input[@name=\'user\']")).click();
            driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    @Test
    public void contactDeletion() {
        if (!isElementPresent(By.name("home"))) {
            driver.findElement(By.linkText("home")).click();
        }

        if (!isElementPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("add new")).click();
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).click();
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("TestFirstName");
            driver.findElement(By.xpath("//input[@name=\'middlename\']")).click();
            driver.findElement(By.xpath("//input[@name=\'middlename\']")).sendKeys("TestMiddleName");
            driver.findElement(By.xpath("//input[@name=\'lastname\']")).click();
            driver.findElement(By.xpath("//input[@name=\'lastname\']")).sendKeys("TestLastName");
            driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
            driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
        }
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
