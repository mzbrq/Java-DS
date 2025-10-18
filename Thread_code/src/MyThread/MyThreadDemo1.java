package MyThread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello MyThread");
    }
}

public class MyThreadDemo1{
    public static void main(String[] args) {
        Thread t = new MyThread();
        System.out.println("hello main");
        t.start();
    }
}
