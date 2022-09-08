/**
 * This file includes all methods for handling GameObjects and Operators
 * 
 * @author Jeffrey Kjelstrom
 * @version September 6, 2022
 */

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

    /**
     * Updates all GameObjects and Operators
     */
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


    /**
     * Draws all GameObjects
     */
    public static void draw(Graphics g) {
        for (GameObject object : objects) {
            object.draw();
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

    /**
     * Adds GameObject to Handler object list
     * @param object GameObject to be added
     */
    public static void addObject(GameObject object) {
        objects.add(object);
    }

    /**
     * Removes GameObject from Handler object list
     * <p>
     * Gets removed after updating and drawing
     * @param object GameObject to be removed
     */
    public static void removeObject(GameObject object) {
        remove.add(object);
    }

    /**
     * Adds GameObject to Handler impact list
     * @param object GameObject to be added
     */
    public static void addImpact(GameObject object) {
        impact.add(object);
    }

    /**
     * Removes GameObject from Handler impact list
     * <p>
     * Gets removed after updating and drawing
     * @param object GameObject to be removed
     */
    public static void removeImpact(GameObject object) {
        removeImpact.add(object);
    }

    /**
     * Adds Operator to Handler operator list
     * @param object Operator to be added
     */
    public static void addOperator(Operator operator) {
        operators.add(operator);
    }

    /**
     * Removes Operator from Handler operator list
     * <p>
     * Gets removed after updating and drawing
     * @param object Operator to be removed
     */
    public static void removeOperator(Operator operator) {
        removeOperators.add(operator);
    }

    /**
     * Changes state of whether or not hit boxes are displayed
     * @param display {@code true} display, {@code false} remove
     */
    public static void displayHitBox(boolean display) {
        displayHitBox = display;
    }
}
