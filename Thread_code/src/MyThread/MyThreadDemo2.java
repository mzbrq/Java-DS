package MyThread;

class MyThread2 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello MyThread2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyThreadDemo2 {
    public static void main(String[] args) {
        Thread t = new MyThread2();
        t.start();
        while (true) {
            System.out.println("hello main");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
