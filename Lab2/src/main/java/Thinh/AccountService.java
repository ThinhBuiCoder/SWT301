package Thinh;

public class AccountService {

    // Phương thức kiểm tra đăng ký tài khoản hợp lệ hay không
    public boolean registerAccount(String username, String password, String email) {
        // Kiểm tra tên đăng nhập không được rỗng
        if (username == null || username.isEmpty()) return false;

        // Mật khẩu phải lớn hơn 6 ký tự
        if (password == null || password.length() <= 6) return false;

        // Email phải đúng định dạng
        if (!isValidEmail(email)) return false;

        return true; // Nếu tất cả điều kiện hợp lệ → cho phép đăng ký
    }

    // Phương thức kiểm tra định dạng email
    public boolean isValidEmail(String email) {
        if (email == null) return false;

        // Regex kiểm tra email hợp lệ: chứa @ và đuôi miền hợp lệ
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // Phương thức kiểm tra mật khẩu mạnh
    public boolean isStrongPassword(String password) {
        if (password == null) return false;

        // Mật khẩu mạnh là: ít nhất 8 ký tự, chứa chữ hoa, chữ thường và số
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}


