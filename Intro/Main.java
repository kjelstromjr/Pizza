/**
 * This program moves a red sqaure across the screen when the user presses the w, a, s, and d, keys
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package Intro;

import pizza.*;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        /*
        *   Initializes and Declares the Pizza object, creating a window for the game and starting the engine
        *   Pass a String to add a title
        *   Add a color in the constructor, using the java.awt.Color class, to change the background color
        */
        Pizza game = new Pizza("Intro");
        /*
        *   Starts a listener for any keyboard changes
        *   Accessed staticaly throught the pizza.Key class
        */
        game.createKeyboardListener();
        /*
        *   Starts a listener for any mouse inputs and changes
        *   Accessed statically through the pizza.Mouse class
        */
        game.createMouseListener();
        /*
        *   Initializes and Declares a GameObject, which can be drawn onto the window
        *   Also can be extended by a new class (see Game)
        *   Methods update() and draw() must be initialized
        */
        GameObject box1 = new GameObject() {

            /*
            *   Most code in here is for your customization to create whatever item you want in the game
            *   This code creates a block that can be moved with w, a, s, and d and turns blue when clicked on
            */

            private int speed = 2;
            private Color color = Color.RED;

            /*
            *   Use this method for any constant checks or changes for the object e.g. animations, keyboard inputs
            */
            @Override
            public void update() {

                // The color of the square will change when clicked on
                if (isPressed()) {
                    color = Color.BLUE;
                } else {
                    color = Color.RED;
                }

                // The square will be moved based on the w, a, s, and d keys
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
                
            }

            /*
            * Use this method to draw out how the object looks using methods in the Graphics object provided by the method
            */
            @Override
            public void draw() {
                // A filled rectangle will be drawn with the current color
                fillRect(color);
            }
        };
        
        // In order for GameObjects to be drawn and updated, they must be added to the game handler
        game.addObject(box1);
    }
}