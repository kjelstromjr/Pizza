/**
 * This file includes all constructors and methods for an operator
 * 
 * @author Jeffrey Kjelstrom
 * @version September 14, 2022
 */

package pizza;

import java.util.Date;

public class Operator {
    private int waitTime = 0;
    private Operation operation;
    private long currTime;

    /**
     * Default constructor
     * @param operation code to be run
     */
    public Operator(Operation operation) {
        this.operation = operation;
    }

    /**
     * Contructor for the operation and wait time
     * @param operation code to be run
     * @param waitTime amount of time before running (miliseconds)
     */
    public Operator(Operation operation, int waitTime) {
        this.operation = operation;
        this.waitTime = waitTime;
        Date date = new Date();
        currTime = date.getTime();
    }

    protected void update() {
        if (new Date().getTime() >= currTime + waitTime) {
            operation.operate();
            currTime = new Date().getTime();
        }
    }
}