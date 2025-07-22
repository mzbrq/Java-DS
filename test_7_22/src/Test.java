import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("==== 快速排序 ====");
        int[] arr1 = {9, 8, 2, 1, 4, 5, 3, 7, 6};
        Sort.quickSort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("==== 快速排序：非递归 ====");
        int[] arr2 = {9, 8, 2, 1, 4, 5, 3, 7, 6};
        Sort.quickSortNor(arr2);
        System.out.println(Arrays.toString(arr2));
    }
    
}
