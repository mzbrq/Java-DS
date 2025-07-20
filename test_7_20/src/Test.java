import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //直接插入排序
        System.out.println("==== 直接插入排序 ====");
        int[] arr1 = {23, 43, 98, 23, 19, 83};
        Sort.insertSort(arr1);
        System.out.println(Arrays.toString(arr1));

        //希尔排序
        int[] arr2 = {32, 45, 12, 34, 43, 11, 9};
        System.out.println("==== 希尔排序 ====");
        Sort.shellSort(arr2);
        System.out.println(Arrays.toString(arr2));

        //直接选择排序
        int[] arr3 = {32, 19, 83, 47, 28, 2, 1};
        System.out.println("==== 直接选择排序：写法一 ====");
        Sort.selectSort1(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {83, 19,3, 47, 28, 2, 1};
        System.out.println("==== 直接选择排序：写法二 ====");
        Sort.selectSort2(arr4);
        System.out.println(Arrays.toString(arr4));

        //堆排序
        int[] arr5 = {83, 19,3, 47, 28, 2, 1};
        System.out.println("==== 堆排序 ====");
        Sort.heapSort(arr5);
        System.out.println(Arrays.toString(arr5));


        //冒泡排序
        int[] arr6 = {83, 19,3, 47, 28, 2, 1};
        System.out.println("==== 冒泡排序 ====");
        Sort.bubbleSort(arr6);
        System.out.println(Arrays.toString(arr6));


        //快速排序：hoare版
        int[] arr7 = {83, 19,3, 47, 28, 2, 1};
        System.out.println("==== 快速排序：hoare版 ====");
        Sort.quickSort(arr7);
        System.out.println(Arrays.toString(arr7));

    }
}
