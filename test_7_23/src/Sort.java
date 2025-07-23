public class Sort {
    //归并排序：递归版
    public static void mergeSort(int[] array) {
        mergeSortChild(array, 0, array.length-1);
    }

    private static void mergeSortChild(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left+right) / 2;

        //递归左边
        mergeSortChild(array, left, mid);
        //递归右边
        mergeSortChild(array, mid+1, right);


        //合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //思路：合并两个有序区间（数组）
        int s1 = left;
        int s2 = mid+1;

        //创建一个临时数组
        int[] tmpArr = new int[right-left+1];
        int k = 0;

        //确保两个区间都有数据
        while (s1 <= mid && s2 <= right) {
            if (array[s2] < array[s1]) {
                tmpArr[k++] = array[s2++];
            } else {
                tmpArr[k++] = array[s1++];
            }
        }

        //把剩余数组数据添加到 tmpArr 中
        while (s1 <= mid) {
            tmpArr[k++] = array[s1++];
        }

        while (s2 <= right) {
            tmpArr[k++] = array[s2++];
        }

        //把 tmpArr 数组元素都返回原数组 array
        for (int i = 0; i < tmpArr.length; i++) {
            array[i+left] = tmpArr[i];
        }
    }

    //归并排序：非递归
    public static void mergeSortNor(int[] array) {
        int gap = 1;

        while (gap < array.length) {
            for (int i = 0; i < array.length; i += 2*gap) {
                int left = i;
                int mid = left+gap-1;
                int right = mid+gap;

                if (mid >= array.length) {
                    mid = array.length-1;
                }

                if (right >= array.length) {
                    right = array.length-1;
                }

                merge(array, left, mid, right);
            }
            gap *= 2;
        }
    }


    //计数排序
    public static void countSort(int[] array) {
        int minVal = array[0];
        int maxVal = array[0];

        //遍历数组找到最大值与最小值
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }

            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        //根据最大值最小值之差创建数组
        int[] count = new int[maxVal-minVal+1];

        //遍历数组找出个数据出现次数并记录
        for (int j = 0; j < array.length; j++) {
            count[array[j]-minVal]++;
        }

        //遍历 计数数组 把数据排序后 放回原数组
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[k++] = i+minVal;
                count[i]--;
            }
        }
    }
}
