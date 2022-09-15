/**
 * This file includes the constructor and methods for the main player in the Star Wars game
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package starwars;

import java.awt.image.BufferedImage;
import java.io.IOException;
import pizza.GameObject;
import pizza.Util;
import pizza.Key;
import pizza.SpriteList;

public class Player extends GameObject {

    // Stores the sprite sheet
    private BufferedImage img;
    // Sets the player's sped
    private int speed = 2;
    // Saves whether or not the user has shot a laser
    public boolean shoot = false;
    // Stores the SpriteList
    private SpriteList list;

    public Player() throws IOException {
        // Gets the image
        img = Util.generateBufferedImage("starwars/player.png");
        // Creates a new SpriteList with 8 sprites and a 2 tick delay
        list = new SpriteList(8, 2);
        // Creates the list of sprites
        list.generateList(img, 0, 0, img.getWidth() / 8, img.getHeight());
        // Sets the width and height
        setWidth(img.getWidth() / 8);
        setHeight(img.getHeight());
    }

    @Override
    public void update() {
        // Basic movements with sprite updates with each movement
        // W
        if (Key.isKeyPressed(87)) {
            setY(getY() - speed);
            list.next();
        }

        // S
        if (Key.isKeyPressed(83)) {
            setY(getY() + speed);
            list.next();
        }

        // A
        if (Key.isKeyPressed(65)) {
            setX(getX() - speed);
            list.next();
        }

        // D
        if (Key.isKeyPressed(68)) {
            setX(getX() + speed);
            list.next();
        }

        // Set the sprite to the "resting" state when the W, A, S, and D keys are not pressed
        if (!Key.isKeyPressed(87) && !Key.isKeyPressed(83) && !Key.isKeyPressed(65) && !Key.isKeyPressed(68)) {
            list.setOn(0);
        }
    }

    @Override
    public void draw() {
        // Draws the current sprite
        drawImage(list.current());
    }
    
}
