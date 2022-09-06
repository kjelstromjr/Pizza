/**
 * This file includes all constructors and methods for an operator
 */

package pizza;

public class Operator {
    private int waitTime = 0;
    private int startTime = 0;
    private Operation operation;

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
     * @param waitTime amount of time before running
     */
    public Operator(Operation operation, int waitTime) {
        this.operation = operation;
        this.waitTime = waitTime / 10;
        startTime = waitTime / 10;
    }

    protected void update() {
        if (waitTime > 0) {
            waitTime--;
        } else {
            operation.operate();
            waitTime = startTime;
        }
    }
}