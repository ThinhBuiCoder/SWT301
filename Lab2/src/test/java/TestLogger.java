import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TestLogger {


    private static final String FILE_PATH = "src/test/resources/unit-test-results.csv";

    /**
     * Ghi log kết quả test vào file CSV
     * @param username  Tên đăng nhập được test
     * @param password  Mật khẩu được test
     * @param email     Email được test
     * @param expected  Kết quả mong đợi (true/false)
     * @param actual    Kết quả thực tế trả về từ hàm kiểm thử
     */
    public static void log(String username, String password, String email, boolean expected, boolean actual) {
        try {
            // Tạo đối tượng File từ đường dẫn
            File file = new File(FILE_PATH);

            // Tạo thư mục cha nếu chưa tồn tại (ví dụ: src/test/resources)
            file.getParentFile().mkdirs();

            // Mở FileWriter ở chế độ append (true) để ghi thêm vào file
            FileWriter writer = new FileWriter(file, true);

            // So sánh expected và actual để xác định kết quả "PASS" hay "FAIL"
            String result = (expected == actual) ? "PASS" : "FAIL";

            // Ghi từng trường dữ liệu ngăn cách bằng dấu phẩy vào file CSV
            writer.append(username).append(",")
                    .append(password).append(",")
                    .append(email).append(",")
                    .append(String.valueOf(expected)).append(",")
                    .append(String.valueOf(actual)).append(",")
                    .append(result).append("\n");

            // Đảm bảo dữ liệu được ghi hết vào file
            writer.flush();

            // Đóng FileWriter sau khi ghi xong
            writer.close();

        } catch (IOException e) {
            // In lỗi nếu có sự cố khi thao tác với file
            e.printStackTrace();
        }
    }
}
