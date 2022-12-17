/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dining.philosophers.problem;

import java.util.ArrayList;

public class DiningPhilosophersProblem {

    public static Philosopher[] createPhilosophers(int n) {
        Chopstick[] chopsticks = new Chopstick[n];

        for (int i = 0; i < n; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        Philosopher[] philosophers = new Philosopher[n];

        for (int i = 0; i < n; i++) {
            Chopstick left = chopsticks[i];
            Chopstick right = chopsticks[(i + 1) % n];

            philosophers[i] = new Philosopher(i, left, right);

        }

        return philosophers;
    }

    public static void main(String[] args) throws InterruptedException {

        Philosopher[] philosophers = createPhilosophers(5);
        int i = 0;
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
        

    }

}
