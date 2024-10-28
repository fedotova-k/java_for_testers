package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactDeletionTest {
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
  public void contactDeletion() {
    driver.get("http://localhost/addressbook/addressbook/");
    driver.manage().window().setSize(new Dimension(1644, 945));
    driver.findElement(By.xpath("//input[@name=\'user\']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name=\'pass\']")).sendKeys("secret");
    driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    driver.findElement(By.xpath("//a[contains(text(),\'home\')]")).click();
  }
}
