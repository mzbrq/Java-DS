public class Sort {
    //直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    //往前放
                    array[j+1] = array[j];
                } else {
                    //tmp放j前面
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
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

    //直接选择排序
    public static void selectSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            //交换
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void selectSort2(int[] array) {
        int left = 0;
        int right = array.length-1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = left;

            for (int i = left+1; i <= right; i++) {
                //找到最小值
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }

                //找到最大值
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }

            //最小值放left
            swap(array, minIndex, left);

            //如果maxIndex 为 left下标时
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            //最大值放right
            swap(array, maxIndex, right);

            //迭代条件
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //堆排序
    public static void heapSort(int[] array) {
        //建大根堆
        createBigHeap(array);

        int end = array.length-1;

        while (end > 0) {
            swap(array, 0, end);
            siftDown(array, 0, end);
            end--;
        }
    }

    private static void createBigHeap(int[] array) {
        for (int parent = (array.length-1-1)/2; parent >= 0; parent--) {
            //向下调整
            siftDown(array, parent, array.length);
        }
    }

    private static void siftDown(int[] array, int parent, int end) {
        int child = 2*parent + 1;

        while (child < end) {
            //找到最大孩子节点
            if (child+1 < end && array[child+1] > array[child]) {
                child++;
            }

            //与双亲节点比较
            if (array[parent] < array[child]) {
                //交换
                swap(array, parent, child);
                //迭代
                parent = child;
                child = 2*parent + 1;
            } else {
                break;
            }
        }
    }


    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = true;
            for (int j = 0; j < array.length-1-i;j++) {
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

    //快速排序
    public static void quickSort(int[] array) {
        quick(array, 0, array.length-1);
    }

    private static void quick(int[] array, int start, int end) {
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

            //找到小于key的元素下标
            while (left < right && array[right] >= key) {
                right--;
            }

            //找到大于key的元素下标
            while (left < right && array[left] <= key) {
                left++;
            }

            //交换
            swap(array, left, right);

        }

        swap(array, left, i);
        return left;

    }
}
