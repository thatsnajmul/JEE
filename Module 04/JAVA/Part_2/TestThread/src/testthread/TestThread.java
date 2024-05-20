package testthread;

public class TestThread {

    public static void main(String[] args) {

        //Value
        Runnable printA = new PrintChar('a', 5);
        Runnable printB = new PrintChar('c', 5);
        Runnable print100 = new PrintNum(10);

        //Thread wise print
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        //Thread start
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
