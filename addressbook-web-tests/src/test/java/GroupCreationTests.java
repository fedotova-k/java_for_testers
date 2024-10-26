import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void createGroupTest() {
        openGroupsPage();
        createGroup(new GroupData("Test group", "header", "footer"));
    }


    @Test
    public void createEmptyGroupTest() {
        openGroupsPage();
        createGroup(new GroupData());
    }

    @Test
    public void createGroupWithName() {
        openGroupsPage();
        createGroup(new GroupData().withName("new name"));
    }
}