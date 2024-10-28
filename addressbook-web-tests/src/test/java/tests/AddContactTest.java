package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddContactTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @org.junit.jupiter.api.Test
    public void addContactTest() {
        driver.get("http://localhost/addressbook/addressbook/");
        driver.manage().window().setSize(new Dimension(1644, 944));
        driver.findElement(By.xpath("//input[@name=\'user\']")).click();
        driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'add new\')]")).click();
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("TestFirstName");
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).click();
        driver.findElement(By.xpath("//input[@name=\'middlename\']")).sendKeys("TestMiddleName");
        driver.findElement(By.xpath("//form[@name=\'theform\']")).click();
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).click();
        driver.findElement(By.xpath("//input[@name=\'lastname\']")).sendKeys("TestLastName");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
    }
}
