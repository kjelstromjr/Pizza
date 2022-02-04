package pizza;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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
     * @return true if touching, false otherwise
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
     * Returns an array of points of the quickest path to a point
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return array of Point objects
     * @see java.awt.Point
     */
    public Point[] getLine(int x1, int y1, int x2, int y2) {
        ArrayList<Point> points = new ArrayList<Point>();
        int dx = x2 - x1;
        int dy = y2 - y1;
        
        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
        
        float Xinc = dx / (float) steps;
        float Yinc = dy / (float) steps;
        
        float x = x1;
        float y = y1;
        for (int i = 0; i <= steps; i++)
        {
            points.add(new Point(Math.round(x), Math.round(y)));
            x += Xinc;
            y += Yinc;
        }

        Point[] newPoints = new Point[points.size()];
        for (int i = 0; i < newPoints.length; i++) {
            newPoints[i] = points.get(i);
        }

        return newPoints;
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
