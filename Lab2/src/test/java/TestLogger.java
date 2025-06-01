import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestLogger {
    private static final String FILE_PATH = "src/test/resources/unit-test-results.csv";

    public static void log(String username, String password, String email, boolean expected, boolean actual) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(file, true);

            String result = (expected == actual) ? "PASS" : "FAIL";

            writer.append(username).append(",")
                    .append(password).append(",")
                    .append(email).append(",")
                    .append(String.valueOf(expected)).append(",")
                    .append(String.valueOf(actual)).append(",")
                    .append(result).append("\n");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
