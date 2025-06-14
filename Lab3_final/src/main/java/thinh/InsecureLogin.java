package thinh;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsecureLogin {

    private static final Logger logger = Logger.getLogger(InsecureLogin.class.getName());

    public static void login(String username, String password) {
        if (username.equals("admin") && password.equals(System.getenv("ADMIN_PASSWORD")) && logger.isLoggable(Level.INFO)) {
            logger.info("Login successful");
        } else if (logger.isLoggable(Level.WARNING)) {
            logger.warning("Login failed");
        }
    }

    public void printUserInfo(String user) {
        if (user != null && !user.isEmpty() && logger.isLoggable(Level.INFO)) {
            logger.info(String.format("User: %s", user));
        }
    }
}
