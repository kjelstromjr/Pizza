/**
 * This is the main file for the game. It initalizes the game, and creates all starting GameObjects
 * 
 * @author Jeffrey Kjelstrom
 * @version September 7, 2022
 */

package Game;

import pizza.Pizza;

public class Game {

    // Initialize and Declare Pizza object
    public static Pizza game = new Pizza();
    // Initialize and Declare custom classes
    public static Player player = new Player();
    public static Food food  = new Food(200, 200);
    public static Counter counter = new Counter(500, 100);

    public Game() {
        // Adds a keyboard listener to the game which is accessed through the pizza.Key class
        game.createKeyboardListener();
        // Custom classes are added to the object handler
        game.addObject(player);
        game.addObject(food);
        game.addObject(counter);
        // Puts a blue box around all objects that is used for other events like intersection and mouse events
        //game.displayHitBox(true);
    }

    public static void main(String[] args) {
        // Starts the game
        new Game();
    }
}
