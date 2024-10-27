package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {
        app.groups().openGroupsPage();
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("New group", "header", "footer"));
        }
        app.groups().removeGroup();
    }

}
