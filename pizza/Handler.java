package pizza;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Handler {
    static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    static ArrayList<GameObject> remove = new ArrayList<GameObject>();
    static ArrayList<GameObject> impact = new ArrayList<GameObject>();
    static ArrayList<GameObject> removeImpact = new ArrayList<GameObject>();
    static ArrayList<Operator> operators = new ArrayList<Operator>();
    static ArrayList<Operator> removeOperators = new ArrayList<Operator>();
    static boolean displayHitBox = false;

    public static void update() {
        for (GameObject object : objects) {
            object.update();
        }

        for (GameObject object : impact) {
            object.checkImpact(impact);
        }

        for (Operator operator : operators) {
            operator.update();
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

        for (int i = 0; i < remove.size(); i++) {
            objects.remove(remove.get(i));
        }

        for (int i = 0; i < removeImpact.size(); i++) {
            impact.remove(removeImpact.get(i));
        }

        for (int i = 0; i < removeOperators.size(); i++) {
            operators.remove(removeOperators.get(i));
        }

        remove.clear();
        removeImpact.clear();
        removeOperators.clear();
    }

    public static void addObject(GameObject object) {
        objects.add(object);
    }

    public static void removeObject(GameObject object) {
        remove.add(object);
    }

    public static void addImpact(GameObject object) {
        impact.add(object);
    }

    public static void removeImpact(GameObject object) {
        removeImpact.add(object);
    }

    public static void addOperator(Operator operator) {
        operators.add(operator);
    }

    public static void removeOperator(Operator operator) {
        removeOperators.add(operator);
    }

    public static void displayHitBox(boolean display) {
        displayHitBox = display;
    }
}
