package MultiThreading;

import java.util.*;

class Q {

    int d[] = new int[5];
    int rear = 0;
    int front = 0;
    Boolean qf = false;
    Boolean qe = true;

    synchronized void get() {
        try {
            while (qe)
                wait();
        } catch (InterruptedException e) {
        }
        front = (front + 1) % 5;
        System.out.println(" Got... d[" + front + "] =" + d[front]);
        if (front == rear) {
            qe = true;
            qf = false;
        }
        notify();
    }

    synchronized void put(int c) {
        try {
            while (qf)
                wait();
        } catch (InterruptedException e) {
        }
        rear = (rear + 1) % 5;
        d[rear] = c;
        System.out.println(" Put... d[" + rear + "] =" + d[rear]);
        if (front == rear) {
            qe = false;
            qf = true;
        }
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    Thread t;

    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Thread t;

    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.get();
            i++;
        }
    }
}

class Threading {
    public static void main(String args[]) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}