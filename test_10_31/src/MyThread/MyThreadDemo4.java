package MyThread;

public class MyThreadDemo4 {
    private static long count;

    synchronized private void add() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadDemo4 mtd = new MyThreadDemo4();

        Thread t1 = new Thread(()-> {
            for (long i = 0; i < 5_000_000; i++) {
                mtd.add();
            }
        });

        Thread t2 = new Thread(()-> {
            for (long i = 5_000_000; i < 10_000_000; i++) {
                mtd.add();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
