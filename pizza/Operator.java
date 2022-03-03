package pizza;

public class Operator {
    private int waitTime = 0;
    private int startTime = 0;
    private Operation operation;

    public Operator(Operation operation) {
        this.operation = operation;
    }

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