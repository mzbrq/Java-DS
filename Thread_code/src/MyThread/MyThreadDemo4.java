package MyThread;

public class MyThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello MyThread4");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

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
