/**
 * This file includes the constructor and methods for the stormtroopers in the Star Wars game
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package starwars;

import java.awt.image.BufferedImage;
import java.io.IOException;

import pizza.GameObject;
import pizza.SpriteList;
import pizza.Util;
import pizza.Window;

public class Stormtrooper extends GameObject {
    // Stores the sprite sheet
    private BufferedImage img;
    // Stores the SpriteList
    private SpriteList list;
    // Sets the location and dimensions
    private int width = 32;
    private int height = 64;
    private int x = 562;
    private int y = 56;

    public Stormtrooper(int startY) throws IOException {
        // Gets the image
        img = Util.generateBufferedImage("starwars/stormtrooper.png");
        // Creates a new SpriteList with 9 sprites and a 5 tick delay
        list = new SpriteList(9, 5);
        // Creates the list of sprites
        list.generateList(img, x, y, width, height);
        // Sets the starting position
        setX(Window.WIDTH);
        setY(startY);
    }

    @Override
    public void update() {
        // Advances the sprite list
        list.next();
        // Moves the stormtrooper to the left
        setX(getX() - 1);
    }

    @Override
    public void draw() {
        // Draws the current sprite to the window
        drawImage(list.current());
    }
}
