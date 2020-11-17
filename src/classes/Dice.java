package classes;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Dice{
    private AtomicLong ai1 = new AtomicLong(0);
    private AtomicLong ai2 = new AtomicLong(0);
    private AtomicLong ai3 = new AtomicLong(0);
    private AtomicLong ai4 = new AtomicLong(0);
    private AtomicLong ai5 = new AtomicLong(0);
    private AtomicLong ai6 = new AtomicLong(0);
    private AtomicLong[] result = {ai1,ai2,ai3,ai4,ai5,ai6};
    private Object[] watcher = {new Object(), new Object(), new Object(), new Object(), new Object(), new Object()};

    @Override
    public String toString() {
        String s = "";
        int total = 0;
        for (int i = 0; i < result.length; i++) {
            s += String.format("Numero %d: %d veces\n", i+1, result[i].get());
            total += result[i].get();
        }

        s += String.format("Total de veces: %d + %d + %d + %d + %d + %d = %d\n", result[0].get(), result[1].get(),
                result[2].get(), result[3].get(), result[4].get(), result[5].get(), total);

        return s;
    }

    public void throwDice(int number){
        result[number-1].addAndGet(number);

        System.out.println("Se ha lanzado el número " + number);


    }
}
