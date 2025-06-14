package thinh;

import java.util.logging.Level;
import java.util.logging.Logger;

// Interface đặt đúng theo chuẩn Java
interface LoginHandler {
    boolean login(String username, String password);
}

class SimpleLoginHandler implements LoginHandler {
    private static final Logger logger = Logger.getLogger(SimpleLoginHandler.class.getName());

    @Override
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            if (logger.isLoggable(Level.WARNING)) {
                logger.warning("Username or password is null.");
            }
            return false;
        }

        if ("admin".equals(username) && "password".equals(password)) {
            if (logger.isLoggable(Level.INFO)) {
                logger.info(String.format("User %s logged in successfully.", username));
            }
            return true;
        } else {
            if (logger.isLoggable(Level.WARNING)) {
                logger.warning(String.format("Failed login attempt for user: %s", username));
            }
            return false;
        }
    }
}

public class InterfaceNamingInconsistencyExample {
    private static final Logger logger = Logger.getLogger(InterfaceNamingInconsistencyExample.class.getName());

    public static void main(String[] args) {
        LoginHandler handler = new SimpleLoginHandler();

        boolean adminLogin = handler.login("admin", "password");
        if (adminLogin) {
            if (logger.isLoggable(Level.INFO)) {
                logger.info("Admin login successful.");
            }
        } else {
            if (logger.isLoggable(Level.WARNING)) {
                logger.warning("Admin login failed.");
            }
        }

        boolean userLogin = handler.login("user", "wrongpass");
        if (userLogin) {
            if (logger.isLoggable(Level.INFO)) {
                logger.info("User login successful.");
            }
        } else {
            if (logger.isLoggable(Level.WARNING)) {
                logger.warning("User login failed.");
            }
        }
    }
}
