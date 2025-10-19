package MyThread;

public class MyThreadDemo8 {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while(!isQuit) {
                System.out.println("Thread8，运行中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread8，结束运行");
        });

        t.start();

        System.out.println("主线程运行中");

        Thread.sleep(5000);

        isQuit = true;
        System.out.println("主线程结束了");
    }
}
