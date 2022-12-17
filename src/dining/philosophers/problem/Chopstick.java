package dining.philosophers.problem;

import java.util.concurrent.Semaphore;

public class Chopstick {

    public int number;
    public Semaphore mutex = new Semaphore(1);
    
    public Chopstick(int number){
        this.number = number;
    }

    public void take() {
        while (!isFree()) {
            try {
                wait();
            } catch (Exception ex) {}
        }
        try {
            mutex.acquire();
        } catch (InterruptedException ex) {}
    }
    
    public void put(){
        mutex.release();
    }

    public boolean isFree() {
        return mutex.availablePermits() > 0;
    }

}
