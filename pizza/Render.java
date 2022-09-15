/**
 * This file renders all GameObject to the window on its own Thread
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package pizza;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;


public class Render extends Thread {

    private Graphics g;
    private Color backgroundColor;
    private Window w;
    private boolean running = true;
    private int renderSpeed = 1;

    public Render(Color backgroundColor, Window w) {
        this.backgroundColor = backgroundColor;
        this.w = w;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(renderSpeed);
                BufferStrategy bs = w.frame.getBufferStrategy();
                if (bs == null) {
                    w.frame.createBufferStrategy(2);
                    continue;
                }
                g = bs.getDrawGraphics();
                Pizza.setGraphicsObject(g);
                g.setColor(backgroundColor);
                g.fillRect(0, 0, Window.WIDTH + 10, Window.HEIGHT);
                Handler.draw(g);
                g.dispose();
                bs.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit");
    }
}
