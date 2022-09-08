/**
 * This is the main class for the Pizza game engine. This includes constructors and methods associated with the main game
 * 
 * @author Jeffrey Kjelstrom
 * @verison September 6, 2022
 */

package pizza;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;

public class Pizza implements Runnable {

    private static JFrame frame;
    public static Thread thread;
    private boolean running;
    public Window w;
    private Color backgroundColor = Color.BLACK;
    private int tickSpeed = 1;
    private boolean key = false;
    private static Graphics g;
    
    /**
     * Default constructor
     */
    public Pizza() {
        w = new Window();
        frame = w.frame;
        start();
    }

    /**
     * Constructor for changing the background color
     * @param backgroundColor
     */
    public Pizza(Color backgroundColor) {
        w = new Window();
        frame = w.frame;
        this.backgroundColor = backgroundColor;
        start();
    }

    /**
     * Constructor for putting the game into fullscreen
     * @param fullScreen
     */
    public Pizza(boolean fullScreen) {
        w = new Window(true);
        frame = w.frame;
        start();
        Math.sin(0.0);
    }

    /**
     * Constructor for putting the game into fullscreen and changing the background color
     * @param backgroundColor
     * @param fullScreen
     */
    public Pizza(Color backgroundColor, boolean fullScreen) {
        w = new Window(true);
        frame = w.frame;
        start();
    }

    /**
     * Starts the game by adding it to a new Thread and starting the game loop
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Ends the game loop
     */
    public synchronized void stop() {
        running = false;
    }

    /**
     * Runs the main game loop
     */
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

    /**
     * Updates all GameObjects and Operators stored in the Handler
     */
    public void update() {
        Handler.update();
    }

    /**
     * Draws all GameObjects stored in the handler
     */
    public void draw() {
        BufferStrategy bs = w.frame.getBufferStrategy();
        if (bs == null) {
            w.frame.createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
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

    public static Graphics getGraphicsObject() {
        return g;
    }
}