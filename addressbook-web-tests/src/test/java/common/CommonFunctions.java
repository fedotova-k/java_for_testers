package common;

import java.util.Random;

public class CommonFunctions {

    public static String randomString(int n) {
        var random = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char) ('a' + random.nextInt(26));
        }
        return result;
    }
}
