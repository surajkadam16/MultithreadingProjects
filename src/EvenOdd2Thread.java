/*
    This class print 1 to 100 using two threads, thread1 print only odd and Thread 2 even.
*/
public class EvenOdd2Thread {
    private int number = 1;

    public static void main(String args[]) throws InterruptedException {
        //System.out.println("hi");
        EvenOdd2Thread threadDemo = new EvenOdd2Thread();

        Thread t1 = new Thread(() -> {
            while (threadDemo.number < 101) {
                threadDemo.printOdd();
            }
        });
        Thread t2 = new Thread(() -> {
            while (threadDemo.number < 101) {
                threadDemo.printEven();
            }
        });
        t1.start();
        Thread.sleep(100);
        t2.start();
    }

    private synchronized void printOdd() {
        System.out.println(number);
        number = number + 1;
        if (number % 2 == 0) {
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printEven() {
        System.out.println(number);
        number = number + 1;
        if (number % 2 == 1) {
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
