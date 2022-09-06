package Gravity;

import java.awt.Graphics;
import pizza.GameObject;
import pizza.Key;
import pizza.Pizza;
import pizza.Window;
import java.awt.Color;

public class Gravity {
    public static void main(String[] args) {
        // Starts game
        Pizza game = new Pizza(true);
        // Initalizes mouse and keyboard listeners
        game.createMouseListener();
        game.createKeyboardListener();

        // Creates a red block that jumps with the space bar and can be picked up and dragged
        GameObject block = new GameObject(100, 500, 100, 100) {

            @Override
            public void update() {
                // Runs gravity code
                runGravity();
                // Allows for the block to be dragged
                draggable();
                // Makes the object be able to collide with other objects
                impactable();

                // Jumps the block when the space bar is pressed
                if (Key.isKeyPressed(32) && (getY() >= Window.HEIGHT - getHeight() || isLanded())) {
                    setVelocity(-30);
                    setY(getY() - 1);
                }
                
                // Moves right when right arrow is pressed
                if (Key.isKeyPressed(39)) {
                    setX(getX() + 2);
                }

                // Moves left when left arrow is pressed
                if (Key.isKeyPressed(37)) {
                    setX(getX() - 2);
                }
            }

            @Override
            public void draw(Graphics g) {
                // Draws data about object to screen at the default location (10, 15)
                displayData(g);
                g.setColor(Color.RED);
                g.fillRect(getX(), getY(), getWidth(), getHeight());
            }
            
        };

        // Creates a green, impactable block that can be dragged
        GameObject block2 = new GameObject(500, 500, 100, 100) {

            @Override
            public void update() {
                // Runs gravity code
                runGravity();
                // Allows for the block to be dragged
                draggable();
                // Makes the object be able to collide with other objects
                impactable();
            }

            @Override
            public void draw(Graphics g) {
                // Draws data about object to screen at the default location plus the offset amount
                displayData(g, 300, 0);
                g.setColor(Color.GREEN);
                g.fillRect(getX(), getY(), getWidth(), getHeight());
            }
            
        };

        //Adds objects to game
        game.addObject(block);
        game.addObject(block2);
    }
}