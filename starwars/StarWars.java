/**
 * This game is a simple shooter game. Use W, A, S, and D to move and Spacebar to shoot
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package starwars;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import pizza.Key;
import pizza.Operator;
import pizza.Pizza;
import pizza.Window;

public class StarWars {

    public static void main(String[] args) throws IOException {
        // Create a new Pizza object with a title an a new background color
        Pizza game = new Pizza("Star Wars", Color.LIGHT_GRAY);

        // Add a keyboard listener for inputs
        game.createKeyboardListener();

        // Creates a new Player object for the user to play as
        Player player = new Player();

        // These list help to keep track of all of the lasers and stromtroopers in the game
        ArrayList<Laser> lasers = new ArrayList<Laser>();
        ArrayList<Stormtrooper> troopers = new ArrayList<Stormtrooper>();

        // If the Spacebar is pressed, SHOOT!
        Operator shoot = new Operator(() -> {
            if (Key.isKeyPressed(32) && !player.shoot) {
                Laser laser = new Laser(player);
                game.addObject(laser);
                lasers.add(laser);
                player.shoot = true;
            }

            if (!Key.isKeyPressed(32)) {
                player.shoot = false;
            }
        });

        // Removes a stormtrooper if they get shot. Also removes the hitting laser
        Operator kill = new Operator(() -> {
            for (int i = 0; i < lasers.size(); i++) {
                for (int j = 0; j < troopers.size(); j++) {
                    if (troopers.get(j).isTouching(lasers.get(i))) {
                        game.removeObject(troopers.get(j));
                        game.removeObject(lasers.get(i));
                        lasers.remove(i);
                        troopers.remove(j);
                        break;
                    }
                }
            }
        });

        // Adds a new stormtrooper at a random y coordinate every 2 seconds
        Operator createTrooper = new Operator(() -> {
            try {
                Stormtrooper st = new Stormtrooper( (int) Math.round(Math.random() * (Window.HEIGHT - 200)) + 50);
                troopers.add(st);
                game.addObject(st);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 2000);

        // Adding the objects and operators
        game.addObject(player);
        game.addOperator(shoot);
        game.addOperator(kill);
        game.addOperator(createTrooper);
    }
}
