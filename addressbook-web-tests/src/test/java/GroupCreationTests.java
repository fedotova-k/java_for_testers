import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void createGroupTest() {
        openGroupsPage();
        createGroup("Test group", "header", "footer");
    }


    @Test
    public void createEmptyGroupTest() {
        openGroupsPage();
        driver.findElement(By.linkText("groups")).click();
        createGroup("", "", "");
    }
}