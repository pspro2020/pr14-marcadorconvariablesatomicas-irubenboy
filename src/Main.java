import classes.Dice;
import classes.Task;

public class Main {
    private static final int MAX_OF_THREAD = 3;

    public static void main(String[] args) {

        Dice d = new Dice(); // Create a dice
        Thread[] threads = new Thread[MAX_OF_THREAD]; // Create a array of threads

        // Create every task like a thread
        for (int i = 0; i < MAX_OF_THREAD; i++) {
            threads[i] = new Thread(new Task(d));
        }

        // Start the threads
        for (int i = 0; i < MAX_OF_THREAD; i++) {
            threads[i].start();
        }

        // Joined threads
        for (int i = 0; i < MAX_OF_THREAD; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("End");
                return;
            }
        }

        System.out.println(d);

    }
}
