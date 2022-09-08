/**
 * This file defines the GameObject for the counter used in the game
 * 
 * @author Jeffrey Kjelstrom
 * @version September 7, 2022
 */

package Game;

import java.awt.Color;
import java.awt.Font;
import pizza.GameObject;

public class Counter extends GameObject {

    int count = 0;

    // Sets the position of the counter using preexisting methods in GameObject
    public Counter(int x, int y) {
        setX(x);
        setY(y);
    }

    // Changes the count integer by the inputed amount
    public void changeCount(int count) {
        this.count += count;
    }

    @Override
    public void update() {
        // Nothing needs to updated, but method still needs to be initialized
        
    }

    @Override
    public void draw() {
        // Draws white text on the screen
        drawText("Eaten: " + count, Color.WHITE, new Font("Arial Black", Font.BOLD, 20));
    }
}
