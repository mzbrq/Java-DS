import java.util.Arrays;

public class TestHeap {
    private int[] elem;
    private int usedSize;

    //构造方法
    public TestHeap() {
        this.elem = new int[10];
    }

    //初始化数组
    public void initHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }

    }

    //创建堆
    public void createHeap() {
        int root = (this.usedSize-1-1) / 2;
        int size = this.usedSize;

        for ( ; root >= 0; root--) {
            //向下调整
            siftDown(root, size);
        }
    }

    //向下调整
    private void siftDown(int parent, int size) {
        //左孩子节点
        int child = 2*parent + 1;

        while (child < size) {
            //找到孩子节点最小的节点
            if (child+1 < size && this.elem[child+1] < this.elem[child]) {
                child++;
            }

            //判断 parent 和 child 大小 是否需要交换
            if (this.elem[parent] > this.elem[child]) {
                //交换
                swap(parent, child);

                //迭代
                parent = child;
                child = 2*parent +1;

            } else {
                break;
            }
        }
    }

    private void swap(int parent, int child) {
        int tmp = this.elem[parent];
        this.elem[parent] = this.elem[child];
        this.elem[child] = tmp;
    }


    //插入
    public void offer(int val) {
        //判断容量
        if (isFull()) {
            //扩容
            grow();
        }

        //将数据插入到最后
        this.elem[this.usedSize] = val;

        //向上调整
        siftUp(this.usedSize);

        this.usedSize++;
    }

    private void siftUp(int child) {
        int parent = (child-1) / 2;

        //判断parent是否存在
        while (child > 0) {
            if (this.elem[parent] > this.elem[child]) {
                //交换
                swap(parent, child);

                //迭代
                child = parent;
                parent = (child-1) / 2;
            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        return this.elem.length == this.usedSize;
    }

    private void grow() {
        this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
    }

    //删除
    public int poll() {
        int ret = this.elem[0];

        //堆顶元素 与 堆中最后一个元素交换
        swap(0, this.usedSize-1);
        this.usedSize--;

        //堆顶元素向下调整
        siftDown(0, this.usedSize);

        //返回删除元素
        return ret;
    }


    public int peek() {
        return this.elem[0];
    }

    //判空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    //堆排序
    public void heapSort() {
        int end = this.usedSize-1;

        while (end > 0) {
            swap(0, end);
            siftDown(0, end);
            end--;
        }
    }



}
