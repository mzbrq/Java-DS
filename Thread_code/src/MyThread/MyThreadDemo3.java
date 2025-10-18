package MyThread;

class MyThread3 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("hello MyThread3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MyThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyThread3());
        t.start();

        while (true) {
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
