package MyThread;

import java.util.Scanner;

public class MyThreadDemo6 {
    private volatile static int flag;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            //t1线程循环读取 flag的值
            while (flag == 0) {
                //循环内部未进行其他操作
            }

            System.out.println("t1 线程结束1");
        });

        Thread t2 = new Thread(()->{
            //t2 线程 修改flag的值
            System.out.println("请修改 flag的值：");
            Scanner scn = new Scanner(System.in);
            flag = scn.nextInt();

        });

        t1.start();
        t2.start();
    }
}
