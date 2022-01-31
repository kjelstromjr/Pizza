package Game;
import java.awt.Graphics;
import java.awt.Color;
import pizza.GameObject;
import pizza.Key;

public class Player extends GameObject {

    private int speed = 2;
    public Color color = Color.GREEN;

    // Changes the color object
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void update() {
        // Moves player depending on the key pressed
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

        // Checks if the player is touching the food
        if (isTouching(Game.food)) {
            Game.food.createNew();
            Game.counter.changeCount(1);
        }
    }

    @Override
    public void draw(Graphics g) {
        // Draws a square with the current color
        g.setColor(color);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
}
