package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {
        if (app.groups().getCount()== 0) {
            app.groups().createGroup(new GroupData("New group", "header", "footer"));
        }
        int GroupCount = app.groups().getCount();

        app.groups().removeGroup();

        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(GroupCount - 1, newGroupCount);
    }

}
