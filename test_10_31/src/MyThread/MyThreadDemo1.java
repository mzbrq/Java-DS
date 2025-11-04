package MyThread;

public class MyThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("MyThread1");
            }
        });

        //线程实例已经创建，未调用 start 在系统内核中创建内核
        System.out.println("调用 start 前：" + t1.isAlive());

        t1.start();

        System.out.println("调用 start 后：" + t1.isAlive());

        //等待 t1 线程执行结束
        t1.join();

        System.out.println(t1.isAlive());
    }
}
