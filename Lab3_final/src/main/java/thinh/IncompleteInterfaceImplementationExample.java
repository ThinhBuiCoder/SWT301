package thinh;

import java.util.logging.Level;
import java.util.logging.Logger;

interface Shape {
    void draw();
    void resize();
}

class Square implements Shape {
    private static final Logger logger = Logger.getLogger(Square.class.getName());

    @Override
    public void draw() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Drawing square");
        }
    }

    @Override
    public void resize() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info("Resizing square");
        }
    }
}

public class IncompleteInterfaceImplementationExample {
    public static void main(String[] args) {
        Shape square = new Square();
        square.draw();
        square.resize();
    }
}
