package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var random = new Random();
        var index = random.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
