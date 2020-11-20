import javax.swing.*;
import java.io.IOException;

public class Main {
    public static final String TITLE = "File Manipulator";

    public static void main(String[] args) throws IOException, TooManyArgumentsException, TooFewArgumentsException {
        JFrame frame = new JFrame(TITLE);
        frame.setSize(500, 400);
        frame.setContentPane(new FileManipulatorGUI(TITLE).getRootPanel());
        frame.setVisible(true);


    }
}

