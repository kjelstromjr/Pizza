/**
 * This file defines the GameObject for the food used in the game
 * 
 * @author Jeffrey Kjelstrom
 * @version September 7, 2022
 */

package Game;

import java.awt.Color;
import pizza.GameObject;
import pizza.Window;

public class Food extends GameObject {

    // Sets the food position, width, and height using preexisting methods from GameObject
    public Food(int x, int y) {
        setX(x);
        setY(y);
        setWidth(10);
        setHeight(10);
    }

    // Moves the food to a random, new location
    public void createNew() {
        int x = (int) (Math.random() * Window.WIDTH + 10);
        int y = (int) (Math.random() * Window.HEIGHT + 60);
        setX(x);
        setY(y);
    }

    @Override
    public void update() {
        // Nothing needs to updated, but method still needs to be initialized
        
    }

    @Override
    public void draw() {
        // Draws a white circle on the window
        fillEllipse(Color.WHITE);
    }
    
}