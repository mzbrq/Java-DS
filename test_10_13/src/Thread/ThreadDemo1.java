package Thread;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("hello world");
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }

}
