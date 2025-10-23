package MyThread;

public class MyThreadDemo2 {
    private static long result = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()-> {
            long tmp = 0;
            for (long i = 1; i < 50_0000_0000L; i++) {
                tmp += i;
            }
            result += tmp;
        });


        Thread t2 = new Thread(()-> {
            long tmp = 0;

            for (long i = 50_0000_0000L; i <= 100_0000_0000L; i++) {
                tmp += i;
            }

            result += tmp;
        });



        t1.start();
        t2.start();

        long beg = System.currentTimeMillis();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println("result = " + result);
        System.out.println("time = " + (end-beg) + "ms");
    }
}
