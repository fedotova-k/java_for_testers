package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void createGroupTest() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new GroupData("Test group", "header", "footer"));
    }

    @Test
    public void createEmptyGroupTest() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void createGroupWithName() {
        app.groups().openGroupsPage();
        app.groups().createGroup(new GroupData().withName("new name"));
    }
}