package pizza;

import java.awt.Graphics;

public abstract class GameObject {
    private int x, y, width, height;

    public GameObject() {
        x = 100;
        y = 100;
        width = 50;
        height = 50;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the GameObject's current x position
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * Get the GameObject's current y position
     * @return int y
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the GameObject's current width
     * @return int width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the GameObject's current height
     * @return int height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the GameObject's x position
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the GameObject's y position
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the GameObject's width
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the GameObject's height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns a boolean based on if the mouse is over the GameObject
     * @return boolean isOver
     */
    public boolean isMouseOver() {
        int x = Mouse.getX();
        int y = Mouse.getY();
        if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a boolean based on if the mouse was clicked over the GameObject
     * @return boolean isClicked
     */
    public boolean isClicked() {
        int x = Mouse.getX();
        int y = Mouse.getY();
        if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight() && Mouse.getMouseState().equals("Clicked")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a boolean based on if the mouse was pressed over the GameObject
     * @return boolean isPressed
     */
    public boolean isPressed() {
        int x = Mouse.getX();
        int y = Mouse.getY();
        if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight() && Mouse.getMouseState().equals("Pressed")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a boolean based on if the mouse was dragged over the GameObject
     * @return boolean isDragged
     */
    public boolean isDragged() {
        int x = Mouse.getX();
        int y = Mouse.getY();
        if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight() && Mouse.getMouseState().equals("Dragged")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if GameObject is intersecting another GameObject
     * by generating a "hit box" for each object.
     * Use displayHitBox() to visually see the hit box of a GameObject
     * @param object
     * @see pizza.Pizza.displayHitBox
     * @return
     */
    public boolean isTouching(GameObject object) {
        /*
        if (getX() > object.getX() && getX() < object.getX() + object.getWidth() && getY() > object.getY() && getY() < object.getY() + object.getHeight()) {
            return true;
        }
        return false;
        */

        if (getX() > object.getX() + object.getWidth() || getX() + getWidth() < object.getX() || getY() > object.getY() + object.getHeight() || getY() + getHeight() < object.getY()) {
            return false;
        }

        return true;
    }

    /**
     * Use this method to make any changes to the individal GameObject.
     * Automatically run by engine.
     */
    public abstract void update();

    /**
     * Use methods in the Graphics g object to draw the GameObject onto the JFrame.\n
     * Make sure that java.awt.Graphics is imported.
     * Automatically run by engine.
     * @param g
     */
    public abstract void draw(Graphics g);
}
