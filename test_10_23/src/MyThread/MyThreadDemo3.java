package MyThread;
class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println(this.getId() + ", " + this.getName());

    }
}

public class MyThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
        });

        Thread t2 = new Thread(()-> {
            System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
        });

        t1.start();
        t2.start();

        Thread t3 = new Thread3();
        t3.start();

        System.out.println(t3.getId() + ", " + t3.getName());

    }
}
