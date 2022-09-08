/**
 * This file defines the GameObject for the main player in the game
 * 
 * @author Jeffrey Kjelstrom
 * @version September 7, 2022
 */

package Game;

import java.awt.Color;
import pizza.GameObject;
import pizza.Key;

public class Player extends GameObject {

    private int speed = 2;
    public Color color = Color.GREEN;
    private int wait = 25;

    // Changes the color object
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void update() {
        // Sets the speed at which the block shrinks
        if (wait > 0) {
            wait--;
        } else {
            setWidth(getWidth() - 1);
            setHeight(getHeight() - 1);
            wait = 25;
        }

        // Moves player depending on the key pressed
        // W
        if (Key.isKeyPressed(87)) {
            setY(getY() - speed);
        }

        // S
        if (Key.isKeyPressed(83)) {
            setY(getY() + speed);
        }

        // A
        if (Key.isKeyPressed(65)) {
            setX(getX() - speed);
        }

        // D
        if (Key.isKeyPressed(68)) {
            setX(getX() + speed);
        }

        // Checks if the player is touching the food
        if (isTouching(Game.food)) {
            Game.food.createNew();
            Game.counter.changeCount(1);
            setWidth(getWidth() + 20);
            setHeight(getHeight() + 20);
        }
    }

    @Override
    public void draw() {
        // Draws a square with the current color
        fillRect(color);
    }
    
}
