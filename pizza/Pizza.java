package pizza;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;

public class Pizza implements Runnable {

    static JFrame frame;
    public static Thread thread;
    boolean running;
    public Window w;
    Color backgroundColor = Color.BLACK;
    private int tickSpeed = 1;
    boolean key = false;
    
    public Pizza() {
        w = new Window();
        frame = w.frame;
        start();
    }

    public Pizza(Color backgroundColor) {
        w = new Window();
        frame = w.frame;
        this.backgroundColor = backgroundColor;
        start();
    }

    public Pizza(boolean fullScreen) {
        w = new Window(true);
        frame = w.frame;
        start();
    }

    public Pizza(Color backgroundColor, boolean fullScreen) {
        w = new Window(true);
        frame = w.frame;
        start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(tickSpeed);
                if (key) {
                    Key.updateKeys();
                }
                update();
                draw();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        Handler.update();
    }

    public void draw() {
        BufferStrategy bs = w.frame.getBufferStrategy();
        if (bs == null) {
            w.frame.createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, Window.WIDTH + 10, Window.HEIGHT);
        Handler.draw(g);
        g.dispose();
        bs.show();
    }

    /**
        Adds a GameObject to be updated and drawn on the JFrame
    */
    public void addObject(GameObject object) {
        Handler.addObject(object);
    }

    /**
     * Removes GameObject from the Handler, thus not to be drawn anymore
     * @param object
     */
    public void removeObject(GameObject object) {
        Handler.removeObject(object);
    }

    /**
     * Adds an Operator to the Handler
     * @param operator
     */
    public void addOperator(Operator operator) {
        Handler.addOperator(operator);
    }

    /**
     * Removes an Operator from the Handler
     * @param operator
     */
    public void removeOperator(Operator operator) {
        Handler.removeOperator(operator);
    }

    /**
     * Displays the hit box of each GameObject
     * @param display
     */
    public void displayHitBox(boolean display) {
        Handler.displayHitBox(display);
    }

    /**
     * Changes the length for which the program waits before running another iteration of updating and drawing objects
     * @param speed
     */
    public void setTickSpeed(int speed) {
        tickSpeed = speed;
    }

    /**
     * Initilizes a key board listener that be be access statically via Key
     */
    public boolean createKeyboardListener() {
        try {
            new Key(frame);
            key = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Initilizes a mouse listener that be be access statically via Mouse
     */
    public boolean createMouseListener() {
        try {
            Mouse m = new Mouse();
            w.getFrame().addMouseListener(m);
            w.getFrame().addMouseMotionListener(m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}