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
        Pizza game = new Pizza();
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

                // Jumps the block when the space bar is pressed
                if (Key.isKeyPressed(32) && getY() >= Window.HEIGHT - getHeight()) {
                    setVelocity(-30);
                    setY(getY() - 1);
                }
            }

            @Override
            public void draw(Graphics g) {
                g.setColor(Color.RED);
                g.fillRect(getX(), getY(), getWidth(), getHeight());
            }
            
        };

        game.addObject(block);
    }
}
