package MyThread;

public class MyThreadDemo5 {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        Thread t1 = new Thread(()-> {
            synchronized (A) {
                try {
                    System.out.println("t1，拿到锁A");
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (B) {
                    System.out.println("t1 拿到两把锁");
                }
            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (A) {
                try {
                    System.out.println("t2,拿到锁B");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (B) {
                    System.out.println("t2，拿到两把锁");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
