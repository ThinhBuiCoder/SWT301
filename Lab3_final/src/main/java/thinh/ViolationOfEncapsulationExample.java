package thinh;

import java.util.logging.Level;
import java.util.logging.Logger;

class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());

    private String name;
    private int age;

    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter và Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method hiển thị thông tin người dùng
    public void display() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Name: %s, Age: %d", name, age));
        }
    }
}
