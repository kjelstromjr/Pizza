package pizza;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Window {
    public int WIDTH, HEIGHT;
    public JFrame frame;
    
    public Window() {
        frame = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) screenSize.getWidth() + 20;
        HEIGHT = (int) screenSize.getHeight();
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-10, 0);
		frame.setVisible(true);
        frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }
}