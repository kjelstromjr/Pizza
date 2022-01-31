package Intro;
import pizza.*;
import java.awt.Color;
import java.awt.Graphics;

public class Main {
    public static void main(String[] args) {
        /*
        *   Initializes and Declares the Pizza object, creating a window for the game and starting the engine
        *   Add a color in the constructor, using the java.awt.Color class, to change the background color
        */
        Pizza game = new Pizza();
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

                if (isPressed()) {
                    color = Color.BLUE;
                } else {
                    color = Color.RED;
                }

                
                if (Key.isKeyPressed(87)) {
                    setY(getY() - speed);
                }

                if (Key.isKeyPressed(83)) {
                    setY(getY() + speed);
                }

                if (Key.isKeyPressed(65)) {
                    setX(getX() - speed);
                }

                if (Key.isKeyPressed(68)) {
                    setX(getX() + speed);
                }
                
            }

            /*
            * Use this method to draw out how the object looks using methods in the Graphics object provided by the method
            */
            @Override
            public void draw(Graphics g) {
                g.setColor(color);
                g.fillRect(getX(), getY(), getWidth(), getHeight()); 
            }
        };
        
        // In order for GameObjects to be drawn and updated, they must be added to the game handler
        game.addObject(box1);
    }
}