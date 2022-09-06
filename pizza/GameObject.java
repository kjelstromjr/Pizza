/**
 * This file includes all constructors and methods for the GameOject class
 * 
 * @author Jeffrey Kjelstrom
 * @version September 6, 2022
 */

package pizza;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public abstract class GameObject {
    private int x, y, width, height;
    private double velocity = 0, acceleration = 1;
    private int preX, preY;
    private boolean dragging = false;
    private int blockX = 0;
    private int blockY = 0;
    private boolean imapacted = false;
    private boolean landed = false;
    private boolean movable = true;
    private boolean touching = false;

    /**
     * Default constructor
     * <p>
     * x = 100, y = 100, width = 50, height = 50
     */
    public GameObject() {
        x = 100;
        y = 100;
        width = 50;
        height = 50;
    }

    /**
     * Custom contructor for GameObject
     * @param x
     * @param y
     * @param width
     * @param height
     */
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
        if (!((x < getX() && blockX == -1) || (x > getX() && blockX == 1)) && movable) {
            this.x = x;
        }
    }

    /**
     * Sets the GameObject's y position
     * @param y
     */
    public void setY(int y) {
        if (!((y < getY() && blockY == -1) || (y > getY() && blockY == 1)) && movable) {
            this.y = y;
        }
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
     * Returns a boolean based on if the mouse was released over the GameObject
     * @return boolean isReleased
     */
    public boolean isReleased() {
        int x = Mouse.getX();
        int y = Mouse.getY();
        if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight() && Mouse.getMouseState().equals("Released")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if GameObject is intersecting another GameObject
     * by generating a "hit box" for each object.
     * Use displayHitBox() to visually see the hit box of a GameObject
     * @param object the object to check if touching
     * @see pizza.Pizza.displayHitBox
     * @return true if touching, false otherwise
     */
    public boolean isTouching(GameObject object) {
        if (getX() > object.getX() + object.getWidth() || getX() + getWidth() < object.getX() || getY() > object.getY() + object.getHeight() || getY() + getHeight() < object.getY()) {
            return false;
        }

        return true;
    }

    /**
     * Returns an array of points of the quickest path to a point
     * @param x1 start x coordinate
     * @param y1 start y coordinate
     * @param x2 end x coordinate
     * @param y2 end y coordinate
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
        for (int i = 0; i <= steps; i++) {
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
     * Updates the GameObject as if there is a gravitational force towards the bottom on the screen.
     * It is recommended to use this method in the update method
     */
    public void runGravity() {
        if (getY() < Window.HEIGHT - getHeight() && !landed) {
            setY((int) Math.round(getY() + velocity));
            velocity += acceleration;
        } else {
            if (landed) {
                velocity = 0;
            } else {
                setY(Window.HEIGHT - getHeight());
                velocity = 0;
            }
        }
    }

    /**
     * Changes the velocity of the GameObject.
     * Only takes effect if <code>runGravity()</code> is run
     * @param velocity
     * @see pizza.GameObject.runGravity
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     * Changes the acceleration of the GameObject.
     * Only takes effect if <code>runGravity()</code> is run
     * @param acceleration
     * @see pizza.GameObject.runGravity
     */
    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Allows for the GameObject to be moved and dragged around the screen by the cursor
     */
    public void draggable() {
        if (isPressed()) {
            preX = Mouse.getX() - getX();
            preY = Mouse.getY() - getY();
        }

        if (isDragged()) {
            setX(Mouse.getX() - preX);
            setY(Mouse.getY() - preY);
            dragging = true;
            velocity = 0;
        }

        if (Mouse.getMouseState().equals("Released")) {
            dragging = false;
        }

        if (dragging) {
            setX(Mouse.getX() - preX);
            setY(Mouse.getY() - preY);
            velocity = 0;
        }
    }

    /**
     * Makes a GameObject impactable.
     * GameObjects that are impactable cannot go through eachother
     */
    public void impactable() {
        if (!imapacted) {
            Handler.addImpact(this);
            imapacted = true;
        }
    }

    /**
     * Removes the "impactablility" of the GameObject
     */
    public void notImpactable() {
        if (imapacted) {
            Handler.removeImpact(this);
            imapacted = false;
        }
    }

    /**
     * Makes an object able to move
     */
    public void movable() {
        movable = true;
    }

    /**
     * Makes an object unable to move
     */
    public void immovable() {
        movable = false;
    }

    /**
     * Updates all objects passed into the method as an ArrayList using a collision algorithm
     * @param objects 
     */
    protected void checkImpact(ArrayList<GameObject> objects) {
        boolean touch = false;
        touching = false;
        boolean tryX;

        for (GameObject object : objects) {
            if (isTouching(object) && object != this) {
                touching = true;
                touch = true;
                tryX = false;
                //System.out.println("touch");
                if (getX() + getWidth() > object.getX() && getX() + getWidth() < object.getX() + object.getWidth()) {
                    tryX = true;
                }
                
                if (getX() + getWidth() <= object.getX()) {
                    blockX = 1;
                    touch = true;
                } else if (getX() >= object.getX() + object.getWidth()) {
                    blockX = -1;
                    touch = true;
                }
                if (getY() + getHeight() > object.getY() && getY() + getHeight() < object.getY() + object.getHeight() && blockX == 0) {
                    setY(object.getY() - getHeight());
                    touch = true;
                }
                if (object.velocity != 0) {
                    blockX = -1;
                }
                if (getY() + getHeight() <= object.getY()) {
                    velocity = 0;
                    landed = true;
                    blockY = 1;
                    touch = true;
                } else if (getY() >= object.getY() + object.getHeight()) {
                    blockY = -1;
                    touch = true;
                }

                if (tryX && blockY == 0) {
                    setX(object.getX() - getWidth());
                }
            }
        }

        if (!touch) {
            blockX = 0;
            blockY = 0;
            landed = false;
        }
    }

    /**
     * @return {@code true} if object has landed, {@code false} otherwise
     */
    public boolean isLanded() {
        return landed;
    }

    /**
     * Displays the object's data at the default (10, 15)
     * <p>
     * <b>Must be run in the {@code draw} method of a GameObject or Operator</b>
     * @param g Graphics object given by the {@code draw()} method
     */
    public void displayData(Graphics g) {
        drawData(g, 0, 0);
    }

    /**
     * Displays the object's data at the default (10, 15) plus the offset coordinates
     * <p>
     * <b>Must be run in the {@code draw} method of a GameObject or Operator</b>
     * @param g Graphics object given by the {@code draw()} method
     * @param x offset X
     * @param y offset Y
     */
    public void displayData(Graphics g, int x, int y) {
        drawData(g, x, y);
    }

    /**
     * Draws data to window
     * @param g Graphics object given by the {@code draw()} method
     * @param offsetX
     * @param offsetY
     */
    private void drawData(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.WHITE);
        g.drawString("X: " + x + ", Y: " + y, 10 + offsetX, 15 + offsetY);
        g.drawString("Width: " + width + ", Height: " + height, 10 + offsetX, 30 + offsetY);
        g.drawString("Velocity: " + velocity, 10 + offsetX, 45 + offsetY);
        g.drawString("Acceleration: " + acceleration, 10 + offsetX, 60 + offsetY);
        g.drawString("Dragging: " + dragging, 10 + offsetX, 75 + offsetY);
        g.drawString("Movable: " + movable, 10 + offsetX, 90 + offsetY);
        g.drawString("Landed: " + landed, 10 + offsetX, 105 + offsetY);
        g.drawString("Block-X: " + blockX, 10 + offsetX, 120 + offsetY);
        g.drawString("Block-Y: " + blockY, 10 + offsetX, 135 + offsetY);
        g.drawString("Touching Object: " + touching, 10 + offsetX, 150 + offsetY);
    }

    /**
     * Use this method to make any changes to the individal GameObject.
     * Automatically run by engine.
     */
    public abstract void update();

    /**
     * Use methods in the Graphics g object to draw the GameObject onto the JFrame.
     * Make sure that java.awt.Graphics is imported.
     * Automatically run by engine.
     * @param g
     */
    public abstract void draw(Graphics g);
}
