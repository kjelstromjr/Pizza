package pizza;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;

public class Pizza{

    static JFrame frame;
    public static Thread tickThread, drawThread;
    boolean running;
    public Window w;
    Color backgroundColor = Color.BLACK;
    private int tickSpeed = (int) (1000 / 60.0);
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
        running = true;
        draw();
        drawThread = new Thread(() -> {
            while (running) {
                try {
                    drawThread.sleep((long)tickSpeed);
                    this.draw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tickThread = new Thread(() -> {
            while (running) {
                try {
                    tickThread.sleep((long)tickSpeed / 2);
                    if (key) {
                        Key.updateKeys();
                    }
                    this.update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        drawThread.start();
        tickThread.start();

        /*
        thread = new Thread(this);
        thread.start();
        running = true;
        */
    }

    /*
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
    */


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