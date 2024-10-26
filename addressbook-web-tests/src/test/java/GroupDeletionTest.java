import org.junit.jupiter.api.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup("New group", "header", "footer");
        }
        removeGroup();
    }

}
