import java.util.Stack;

public class Sort {
    //快速排序
    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        if (end - start + 1 >= 7) {
            //直接插入
            insertSortRange(array, start, end);
            return;
        }
        int midIndex = midOfThree(array, start, end);
        swap(array, midIndex, start);

        int pivot = partition1(array, start, end);

        quick(array, start, pivot-1);
        quick(array, pivot+1, end);
    }

    private static void insertSortRange(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            int j = i-1;
            int tmp = array[i];
            for (; j >= start; j--) {
                if (tmp < array[j]) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    private static int midOfThree(int[] array, int left, int right) {
        int mid = (left+right) / 2;

        if (array[left] < array[right]) {
            if (array[left] > array[mid]) {
                return left;
            } else if (array[right] < array[mid]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[right] > array[mid]) {
                return right;
            } else if (array[left] < array[mid]) {
                return left;
            } else {
                return mid;
            }
        }
    }

    private static int partitionHoare(int[] array, int left, int right) {
        int key = array[left];
        int i = left;

        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }

            while (left < right && array[left] <= key) {
                left++;
            }

            swap(array, left, right);
        }

        swap(array, i, left);

        return left;
    }

    //挖坑法
    private static int partition1(int[] array, int left, int right) {
        int key = array[left];
        int i = left;

        while (left < right) {
            while (left < right && array[right] >= key) {
                right--;
            }

            array[left] = array[right];

            while (left < right && array[left] <= key) {
                left++;
            }

            array[right] = array[left];
        }

        array[left] = key;

        return left;
    }



    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    //快速排序：非递归
    public static void quickSortNor(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length-1;

        //找基准
        int pivot = partition1(array, left, right);

        //判断基准左边是否有两个以上元素
        if (pivot-1 > left) {
            //存在两个以上元素，入栈
            stack.push(left);
            stack.push(pivot-1);
        }

        //判断基准右边是否有两个以上元素
        if (pivot+1 < right) {
            //存在两个以上元素，入栈
            stack.push(pivot+1);
            stack.push(right);
        }

        while (!stack.isEmpty()) {
            //先入left,后入right，所以先出right
            right = stack.pop();
            left = stack.pop();

            //找基准
            pivot = partition1(array, left, right);

            //判断基准左边是否有两个以上元素
            if (pivot-1 > left) {
                //存在两个以上元素，入栈
                stack.push(left);
                stack.push(pivot-1);
            }

            //判断基准右边是否有两个以上元素
            if (pivot+1 < right) {
                //存在两个以上元素，入栈
                stack.push(pivot+1);
                stack.push(right);
            }

        }
    }

}
