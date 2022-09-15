/**
 * This file updates all GameObjects and Operators on it's own Thread
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package pizza;

public class Tick extends Thread {

    private boolean running = true;
    private static int tickSpeed = 20;
    
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(tickSpeed);
                if (Pizza.key) {
                    Key.updateKeys();
                }
                Handler.update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected static void setTickSpeed(int tick) {
        tickSpeed = tick;
    }

}
