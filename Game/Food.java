package Game;
import java.awt.Color;
import java.awt.Graphics;
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
    public void draw(Graphics g) {
        // Draws a white circle on the window
        g.setColor(Color.WHITE);        
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
    
}