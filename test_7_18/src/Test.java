import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void orderSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void notOrderSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }
    }

    public static void notOrderSortRandom(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
    }

    public static void testInsertSort(int[] array) {
        int[] tmp = Arrays.copyOf(array, array.length);

        long startTime = System.currentTimeMillis();

        Sort.insertSort(tmp);

        long endTime = System.currentTimeMillis();

        System.out.println("排序消耗时间：" + (endTime - startTime));


    }

    public static void testShellSort(int[] array) {
        int[] tmp = Arrays.copyOf(array, array.length);

        long startTime = System.currentTimeMillis();

        Sort.shellSort(tmp);

        long endTime = System.currentTimeMillis();

        System.out.println("排序消耗时间：" + (endTime - startTime));


    }

    public static void main(String[] args) {
        int[] array1 = {100, 89, 98, 33, 43, 23};

        Sort.insertSort(array1);

        System.out.println(Arrays.toString(array1));

        int[] arr1 = new int[10000];

        System.out.println("===== 有序 ======");
        orderSort(arr1);
        testInsertSort(arr1);

        System.out.println("===== 完全逆序 ======");
        notOrderSort(arr1);
        testInsertSort(arr1);

        System.out.println("===== 随机无序 ======");
        notOrderSortRandom(arr1);
        testInsertSort(arr1);


        //希尔排序
        System.out.println("===== 希尔排序 ======");
        int[] array2 = {99, 23, 43, 12, 54, 87};
        int[] arr2 = new int[10000];
        Sort.shellSort(array2);
        System.out.println(Arrays.toString(array2));

        System.out.println("===== 逆序 ======");
        notOrderSort(arr2);
        testShellSort(arr2);

        System.out.println("===== 有序 ======");
        orderSort(arr2);
        testShellSort(arr2);





    }
}
