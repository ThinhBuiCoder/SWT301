import static org.junit.jupiter.api.Assertions.*;

import Thinh.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class AccountServiceTest {

    private final AccountService service = new AccountService();

    // Test đăng ký tài khoản từ file test-data.csv
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean actual = service.registerAccount(username, password, email);

        // Ghi log kết quả sau mỗi test
        TestLogger.log(username, password, email, expected, actual);

        assertEquals(expected, actual);
    }


    // Test email hợp lệ hoặc không
    @ParameterizedTest
    @CsvSource({
            "user@example.com, true",
            "user.example.com, false",
            "user@.com, false",
            "@example.com, false",
            "user@domain.co, true"
    })
    void testIsValidEmail(String email, boolean expected) {
        boolean result = service.isValidEmail(email);
        assertEquals(expected, result);
    }

    // Test mật khẩu mạnh hoặc không
    @ParameterizedTest
    @CsvSource({
            "Password1, true",        // chứa hoa, thường, số
            "password1, false",       // thiếu chữ hoa
            "PASSWORD1, false",       // thiếu chữ thường
            "Passw1, false",          // quá ngắn
            "PassWord, false",        // thiếu số
            "Pass1234, true"
    })
    void testIsStrongPassword(String password, boolean expected) {
        boolean result = service.isStrongPassword(password);
        assertEquals(expected, result);
    }
}
