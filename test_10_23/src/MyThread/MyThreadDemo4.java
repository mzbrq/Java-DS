package MyThread;

class MyThread4 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread4 运行中");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread4 结束");
    }
}

public class MyThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread4();
        // 线程对象创建，但系统线程还未创建，状态：NEW
        System.out.println(t.getState());

        t.start();
        // 系统线程创建完成，处于就绪状态，状态：Runnable
        System.out.println(t.getState());

        Thread.sleep(2000);

        //t 线程休眠中，状态：TIMED_WAITING
        System.out.println(t.getState());

        t.join(); //join,等待 t 线程执行完毕

        //系统线程执行完毕，Thread 对象还存在，状态：TERMINATED
        System.out.println(t.getState());


    }
}
