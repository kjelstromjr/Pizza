package Game;
import java.awt.Graphics;
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
    public void draw(Graphics g) {
        // Draws white text on the screen
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial Black", Font.BOLD, 20));
        g.drawString("Eaten: " + count, getX(), getY());
    }
}
