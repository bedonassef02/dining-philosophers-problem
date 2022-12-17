package dining.philosophers.problem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Philosopher extends Thread {

    public boolean eat = false;
    public int number;
    public Chopstick leftChopstick;
    public Chopstick rightChopstick;
    Semaphore sem = new Semaphore(1);
    public static int count = 0;

    public Philosopher(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.number = number;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run() {
        while (!eat) {
            System.out.println("Philosopher " + number + " is thinking");
            if (number == 0) {
                leftChopstick.take();
                System.out.println("Philosopher " + number + " took the left fork " + leftChopstick.number);
                rightChopstick.take();
                System.out.println("Philosopher " + number + " took the right fork " + rightChopstick.number);
            } else {
                rightChopstick.take();
                System.out.println("Philosopher " + number + " took the right fork " + rightChopstick.number);
                leftChopstick.take();
                System.out.println("Philosopher " + number + " took the left fork " + leftChopstick.number);
            }
            System.out.println("Philosopher " + number + " is eating...");
            leftChopstick.put();
            System.out.println("Philosopher " + number + " put the left fork " + leftChopstick.number);
            rightChopstick.put();
            System.out.println("Philosopher " + number + " put the right fork " + rightChopstick.number);
            eat = true;
            try {
                sem.acquire();
                this.count++;
                System.out.println("Count : "+count);
                sem.release();
            } catch (InterruptedException ex) {
            }
        }
    }

}
