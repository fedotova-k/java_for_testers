import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupDeletionTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void groupDeletionTest() {
        driver.get("http://localhost/addressbook/addressbook/");
        driver.manage().window().setSize(new Dimension(1644, 937));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.xpath("//input[@name=\'selected[]\']")).click();
        driver.findElement(By.xpath("//input[@name=\'delete\']")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'groups\')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'Logout\')]")).click();
    }
}
