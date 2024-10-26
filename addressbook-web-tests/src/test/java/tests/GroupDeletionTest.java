package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("New group", "header", "footer"));
        }
        app.removeGroup();
    }

}
