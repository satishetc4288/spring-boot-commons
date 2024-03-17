package com.satish.exp.problems;
import java.util.Random;
public class ICE {
    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue(10);
        Thread t1 = new Thread( () -> {
            while(true){
                try { queue.consume(); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
        });
        Thread t2 = new Thread( () -> {
            while(true){
                try { queue.produce(); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
        });
        t1.start(); t2.start();
    }
}

class Queue {
    private int[] arr;
    private int pointer = -1;
    private int size;
    public Queue(int size){
        this.size = size;
        this.arr = new int[size];
    }

    public synchronized void consume() throws InterruptedException {
        if(pointer == -1){
            return ;
        }
        while(pointer > -1) {
            System.out.println("Consuming this element: " + arr[pointer]);
            pointer--;
        }
        this.notify();
        this.wait();
    }

    public synchronized void produce() throws InterruptedException {
        if(pointer == (size-1)){
            return;
        }
        while(pointer < (size-1)) {
            pointer++;
            arr[pointer] = new Random().nextInt(100);
            System.out.println("Producing this element: " + arr[pointer]);
        }
        this.notify();
        this.wait();
    }

}
