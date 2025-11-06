package MyThread;

public class MyThreadDemo7 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread t1 = new Thread(()-> {
            synchronized (locker) {
                System.out.println("t1 wait 前");

                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t2 wait 后");

            }
        });

        Thread t2 = new Thread(()-> {
            //先让t2线程 休眠 5秒，确保t1线程拿到锁，调用wait()
            try {
                Thread.sleep(5000);

                synchronized (locker) {
                    System.out.println("t2 notify 之前");
                    locker.notify();
                    System.out.println("t2 notify 之后");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }
}
