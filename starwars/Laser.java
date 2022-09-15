/**
 * This file includes the constructor and methods for the lasers in the Star Wars game
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package starwars;

import java.awt.Color;

import pizza.GameObject;
import pizza.Handler;
import pizza.Window;

public class Laser extends GameObject {

    public Laser(Player player) {
        // Sets the dimensions and start position
        setX(player.getX() + 32);
        setY(player.getY() + 12);
        setWidth(20);
        setHeight(2);
    }

    @Override
    public void update() {
        // Moves the laser to the right
        setX(getX() + 30);
        // Removes the laser if it gets to the edge of the screen
        if (getX() >= Window.WIDTH) {
            Handler.removeObject(this);
        }
    }

    @Override
    public void draw() {
        // Draws a red rectangle as the laser
        fillRect(Color.RED);
    }
    
}
