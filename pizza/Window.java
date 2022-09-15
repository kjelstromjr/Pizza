/**
 * This file includes all constructors and methods for the window
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package pizza;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {
    public static int WIDTH, HEIGHT;
    public JFrame frame;
    
    /**
     * Defualt contructor 
     */
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
                //Pizza.thread.interrupt();
                System.exit(0);
            }
        });
    }

    /**
     * Constructor with title
     * @param title
     */
    public Window(String title) {
        frame = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) screenSize.getWidth() + 20;
        HEIGHT = (int) screenSize.getHeight();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-10, 0);
		frame.setVisible(true);
        frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //Pizza.thread.interrupt();
                System.exit(0);
            }
        });
    }

    /**
     * Constructor with fullscreen
     * @param fullScreen {@code true} fullscreen, {@code false} not fullscreen
     */
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
                //Pizza.thread.interrupt();
                System.exit(0);
            }
        });
    }

    /**
     * Constructor with fullscreen and title
     * @param fullScreen {@code true} fullscreen, {@code false} not fullscreen
     */
    public Window(String title, boolean fullScreen) {
        frame = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int) screenSize.getWidth() + 20;
        HEIGHT = (int) screenSize.getHeight();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(fullScreen); 
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(-10, 0);
		frame.setVisible(true);
        frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //Pizza.thread.interrupt();
                System.exit(0);
            }
        });
    }


    /**
     * Gets the JFrame object of window
     * @return JFrame object
     */
    public JFrame getFrame() {
        return frame;
    }
}