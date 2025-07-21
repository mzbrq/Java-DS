import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("==== 直接插入排序 =====");
        int[] arr1 = {9, 7, 4, 8, 3, 1};
        Sort.insertSort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("==== 希尔排序 =====");
        int[] arr2 = {9, 7, 4, 8, 3, 1};
        Sort.shellSort(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("==== 直接选择排序：写法一 =====");
        int[] arr3 = {9, 7, 4, 8, 3, 1};
        Sort.selectSort1(arr3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("==== 直接选择排序：写法二 =====");
        int[] arr4 = {9, 7, 4, 8, 3, 1};
        Sort.selectSort2(arr4);
        System.out.println(Arrays.toString(arr4));

        System.out.println("==== 堆排序 =====");
        int[] arr5 = {9, 7, 4, 8, 3, 1};
        Sort.heapSort(arr5);
        System.out.println(Arrays.toString(arr5));

        System.out.println("==== 冒泡排序 =====");
        int[] arr6 = {9, 7, 4, 8, 3, 1};
        Sort.bubbleSort(arr6);
        System.out.println(Arrays.toString(arr6));

        System.out.println("==== 快速排序:hoare版 =====");
        int[] arr7 = {9, 7, 4, 8, 3, 1};
        Sort.quickSort(arr7);
        System.out.println(Arrays.toString(arr7));
    }
}
