package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void createGroupTest() {
        int GroupCount = app.groups().getCount();
        app.groups().createGroup(new GroupData("Test group", "header", "footer"));
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(GroupCount + 1, newGroupCount);
    }

    @Test
    public void createEmptyGroupTest() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void createGroupWithName() {
        app.groups().createGroup(new GroupData().withName("new name"));
    }

    @Test
    public void createMultipleGroups() {
        int n = 5;
        int GroupCount = app.groups().getCount();

        for (int i = 0; i < n; i++) {
            app.groups().createGroup(new GroupData(randomString(i * 5), "header", "footer"));
        }
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(GroupCount + n, newGroupCount);
    }
}