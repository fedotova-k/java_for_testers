import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup(new GroupData("New group", "header", "footer"));
        }
        removeGroup();
    }

}
