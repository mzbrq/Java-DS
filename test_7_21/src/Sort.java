public class Sort {

    //直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;

            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
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

    //直接选择排序
    public static void selectSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            swap(array, minIndex, i);
        }
    }

    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length-1;

        while (left < right) {
            int maxIndex = left;
            int minIndex = left;

            for (int i = left+1; i <= right; i++) {
                //找到left 到 right 之间的最大值
                if (array[maxIndex] < array[i]) {
                    maxIndex = i;
                }

                //找到left 到 right 之间的最小值
                if (array[minIndex] > array[i]) {
                    minIndex = i;
                }
            }

            //交换最小值
            swap(array, minIndex, left);

            //判断 最大值下标知否在left
            if (maxIndex == left) {
                maxIndex = minIndex;
            }

            swap(array, maxIndex, right);

            left++;
            right--;
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        //建大根堆
        createBigHeap(array);

        int end = array.length-1;

        while (end >= 0) {
            swap(array, 0, end);
            siftDown(array, 0, end);
            end--;
        }
    }

    private static void createBigHeap(int[] array) {
        int parent = (array.length-1-1)/2;
        for (; parent >= 0; parent--) {
            //向下调整
            siftDown(array, parent, array.length);
        }
    }

    private static void siftDown(int[] array, int parent, int end) {
        int child = 2*parent + 1;

        while (child < end) {
            if (child+1 < end && array[child+1] > array[child]) {
                child++;
            }

            if (array[parent] < array[child]) {
                swap(array, parent, child);

                parent = child;
                child = 2*parent + 1;
            } else {
                break;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flg = true;
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    flg = false;
                }
            }

            if (flg) {
                return;
            }
        }
    }

    //快速排序:hoare版
    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int start, int end) {
        //左边只有一个节点 或 一个节点也没有
        if (start >= end) {
            return;
        }
        int pivot = partition(array, start, end);

        quick(array, start, pivot-1);
        quick(array, pivot+1, end);
    }

    private static int partition(int[] array, int left, int right) {
        int key = array[left];
        int i = left;

        while (left < right) {
            //right 找到 小于 key 的下标
            while (left < right && array[right] >= key) {
                right--;
            }

            //left 找到 大于 key 的下标
            while (left < right && array[left] <= key) {
                left++;
            }

            //交换left 和 right 元素
            if (left != right) {
                swap(array, left, right);
            }
        }

        //交换 key 和 left = right 位置
        swap(array, i, left);

        return left;
    }

}
