package thinh;

import org.junit.jupiter.api.Test;

class InsecureLoginTest {

    @Test
    void testLoginSuccess() {
        InsecureLogin.login("admin", "123456");
    }

    @Test
    void testLoginFail() {
        InsecureLogin.login("user", "wrongpassword");
    }

    @Test
    void testPrintUserInfo() {
        InsecureLogin insecureLogin = new InsecureLogin();
        insecureLogin.printUserInfo("John Doe");
    }
}
