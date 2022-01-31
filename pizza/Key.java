package pizza;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.util.LinkedList;

public class Key implements KeyListener {

    private static LinkedList<Integer> keys = new LinkedList<Integer>();
    private static LinkedList<Integer> addKeys = new LinkedList<Integer>();
    private static LinkedList<Integer> removeKeys = new LinkedList<Integer>();

    public Key(JFrame frame) {
        frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        addKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        removeKeys.add(e.getKeyCode());
    }

    /**
     * Determines if a key is currently pressed
     * @param key
     * @return true: pressed; false: not pressed
     */
    public static boolean isKeyPressed(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == key) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if a key is currently pressed
     * @param key
     * @return true: pressed; false: not pressed
     */
    public static boolean isKeyPressed(char key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == (int) key) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates which keys are and are not pressed.
     * Automatically used by engine.
     * NOT recommended to use.
     */
    public static void updateKeys() {
        for (int i = 0; i < addKeys.size(); i++) {
            boolean found = false;
            for (int j = 0; j < keys.size(); j++) {
                if (keys.get(j) == addKeys.get(i)) {
                    found = true;
                }
            }
            if (!found) {
                keys.add(addKeys.get(i));
            }
        }
        addKeys.clear();
        for (int i = 0; i < removeKeys.size(); i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (keys.get(j) == removeKeys.get(i)) {
                    keys.remove(j);
                }
            }
        }
        removeKeys.clear();
    }
}