import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("==== 归并排序：递归版 ====");
        int[] arr1 = {9, 8, 3, 10, 23, 87, 31};
        Sort.mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("==== 归并排序：非递归版 ====");
        int[] arr2 = {9, 8, 3, 10, 23, 87, 31};
        Sort.mergeSortNor(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("==== 计数排序 ====");
        int[] arr3 = {9, 8, 3, 10, 23, 87, 31};
        Sort.countSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
