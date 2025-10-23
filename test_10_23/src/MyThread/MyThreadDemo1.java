package MyThread;

public class MyThreadDemo1 {
    private static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        //一个线程计算后，汇总到main 方法中
        Thread t = new Thread(()-> {
            for (long i = 1; i <= 100_0000_0000L; i++) {
                count += i;
            }
        });

        t.start();
        long beg = System.currentTimeMillis();

        t.join();

        long end = System.currentTimeMillis();

        System.out.println("count = " + count);
        System.out.println("time = " + (end - beg) + "ms");


    }
}
