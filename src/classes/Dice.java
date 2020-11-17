package classes;

import java.util.Random;

public class Dice{

    private int[] result = {0,0,0,0,0,0};
    private Object[] watcher = {new Object(), new Object(), new Object(), new Object(), new Object(), new Object()};

    @Override
    public String toString() {
        String s = "";
        int total = 0;
        for (int i = 0; i < result.length; i++) {
            s += String.format("Numero %d: %d veces\n", i+1, result[i]);
            total += result[i];
        }

        s += String.format("Total de veces: %d + %d + %d + %d + %d + %d = %d\n", result[0], result[1], result[2],
                result[3], result[4], result[5], total);

        return s;
    }

    public void throwDice(int number){
        synchronized (watcher[number-1]) {
            result[number - 1]++;
        }

        System.out.println("Se ha lanzado el número " + number);


    }
}
