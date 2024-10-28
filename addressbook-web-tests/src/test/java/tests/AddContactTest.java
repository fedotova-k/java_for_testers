package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddContactTest {

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
    public void addContactTest() {
        if (!isElementPresent(By.name("submit"))) {
            driver.findElement(By.linkText("add new")).click();
        }
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("TestFirstName");
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).click();
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).sendKeys("TestMiddleName");
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).sendKeys("TestLastName");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }

    @Test
    public void addContactTestWithEmptyNames() {
        if (!isElementPresent(By.name("submit"))) {
            driver.findElement(By.linkText("add new")).click();
        }
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).click();
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).sendKeys("");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }

    @Test
    public void addContactTestWithAnotherNames() {
        if (!isElementPresent(By.name("submit"))) {
            driver.findElement(By.linkText("add new")).click();
        }
        driver.findElement(By.xpath("//input[@name=\'nickname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'nickname\']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name=\'title\']")).click();
        driver.findElement(By.xpath("//input[@name=\'title\']")).sendKeys("some company");
        driver.findElement(By.xpath("//input[@name=\'mobile\']")).click();
        driver.findElement(By.xpath("//input[@name=\'mobile\']")).sendKeys("875415");
        driver.findElement(By.xpath("//select[@name=\'bday\']")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '15']")).click();
        }
        driver.findElement(By.xpath("//option[@value=\'15\']")).click();
        driver.findElement(By.xpath("//select[@name=\'bmonth\']")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'September']")).click();
        }
        driver.findElement(By.xpath("//input[@name=\'byear\']")).click();
        driver.findElement(By.xpath("//input[@name=\'byear\']")).sendKeys("2000");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
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
