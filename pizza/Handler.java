package pizza;

import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Color;

public class Handler {
    static LinkedList<GameObject> objects = new LinkedList<GameObject>();
    static boolean displayHitBox = false;

    public static void update() {
        for (GameObject object : objects) {
            object.update();
        }
    }

    public static void draw(Graphics g) {
        for (GameObject object : objects) {
            object.draw(g);
            if (displayHitBox) {
                g.setColor(Color.BLUE);
                g.drawRect(object.getX(), object.getY(), object.getWidth(), object.getHeight());
            }
        }
    }

    public static void addObject(GameObject object) {
        objects.add(object);
    }

    public static void removeObject(GameObject object) {
        objects.remove(object);
    }

    public static void displayHitBox(boolean display) {
        displayHitBox = display;
    }
}
