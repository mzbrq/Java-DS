public class Sort {
    //直接插入排序
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;

            for (; j >= 0; j--) {
                if (tmp > arr[j]) {
                    //直接把tmp 放到 j下标元素的前面
                    //arr[j+1] = tmp;
                    break;
                } else {
                    //j 下标位置元素往前放
                    arr[j+1] = arr[j];
                }
            }

            arr[j+1] = tmp;

        }
    }


    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;

        while (gap > 1) {
            gap /= 2;
            shell(array, gap);
        }
    }

    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i-gap;

            for (; j >= 0; j-=gap) {
                if (array[j] > tmp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
}
