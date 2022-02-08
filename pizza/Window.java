package pizza;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {
    public static int WIDTH, HEIGHT;
    public JFrame frame;
    
    public Window() {
        frame = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) screenSize.getWidth() + 20;
        HEIGHT = (int) screenSize.getHeight();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-10, 0);
		frame.setVisible(true);
        frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Pizza.thread.interrupt();
                System.exit(0);
            }
        });
    }

    public Window(boolean fullScreen) {
        frame = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) screenSize.getWidth() + 20;
        HEIGHT = (int) screenSize.getHeight();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(fullScreen); 
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-10, 0);
		frame.setVisible(true);
        frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Pizza.thread.interrupt();
                System.exit(0);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}