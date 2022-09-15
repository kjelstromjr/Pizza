/**
 * This file contains all constructors and methods for creating a sprite list
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package pizza;

import java.awt.image.BufferedImage;

public class SpriteList {
    private BufferedImage[] sprites;
    private int on = 0;
    private int delay = 0;
    private int wait = 0;

    /**
     * Creates a SpriteList with the given size
     * @param size
     */
    public SpriteList(int size) {
        sprites = new BufferedImage[size];
    }

    /**
     * Creates a SpriteList with the given size and adds the given delay time for which the engine will wait for before moving to the next sprite
     * @param size
     * @param delay number of tick cycles
     */
    public SpriteList(int size, int delay) {
        sprites = new BufferedImage[size];
        this.delay = delay;
    }

    /**
     * Populates the SpriteList with the given array
     * @param list
     */
    public void set(BufferedImage[] list) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = list[i];
        }
    }

    /**
     * Returns the BufferedImage at the given index of the SpriteList
     * @param index
     * @return
     */
    public BufferedImage get(int index) {
        return sprites[index];
    }

    /**
     * Advances to the next sprite image, or waits
     */
    public void next() {
        if (wait == delay) {
            on++;
            if (on >= sprites.length) {
                on = 0;
            }
            wait = 0;
        } else {
            wait++;
        }
    }

    /**
     * Returns the current sprite's image
     * @return
     */
    public BufferedImage current() {
        return sprites[on];
    }

    /**
     * Set the current position of the SpriteList
     * @param on
     */
    public void setOn(int on) {
        this.on = on;
    }

    /**
     * Returns the current position of the SpriteList
     * @return
     */
    public int getOn() {
        return on;
    }

    /**
     * Creates and new SpriteList with the given BufferedImage and the dimensions of one sprite
     * @param img
     * @param startX which x coordinate to start reading at
     * @param startY which y coordinate to start reading at
     * @param width of sprite
     * @param height of sprite
     */
    public void generateList(BufferedImage img, int startX, int startY, int width, int height) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = img.getSubimage((i * width) + startX, startY, width, height);
        }
    }
}
