import java.util.Arrays;

public class MyHeap {
    private int[] elem;      // 存储堆元素的数组
    private int usedSize;    // 已使用的元素个数

    // 无参构造方法，默认容量为10
    public MyHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    // 带初始容量的构造方法
    public MyHeap(int capacity) {
        this.elem = new int[capacity];
        this.usedSize = 0;
    }

    // 交换数组中两个元素的位置
    private void swap(int i, int j) {
        int tmp = this.elem[i];
        this.elem[i] = this.elem[j];
        this.elem[j] = tmp;
    }

    // 判断堆是否已满
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    // 数组扩容（2倍）
    private void grow() {
        this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
    }

    // 向下调整（小顶堆）
    private void siftDown(int parent, int size) {
        // 左孩子节点
        int child = 2 * parent + 1;

        while (child < size) {
            // 找到孩子节点中最小的节点
            if (child + 1 < size && this.elem[child + 1] < this.elem[child]) {
                child++;
            }

            // 判断 parent 和 child 大小，是否需要交换
            if (this.elem[parent] > this.elem[child]) {
                // 交换
                swap(parent, child);

                // 迭代
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    // 向上调整（小顶堆）
    private void siftUp(int child) {
        int parent = (child - 1) / 2;

        // 判断parent是否存在
        while (child > 0) {
            if (this.elem[parent] > this.elem[child]) {
                // 交换
                swap(parent, child);

                // 迭代
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    // 用给定数组初始化堆
    public void initHeap(int[] arr) {
        // 如果数组长度大于当前容量，需要扩容
        if (arr.length > this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, arr.length);
        }

        // 复制元素到堆数组
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
    }

    // 创建堆（从最后一个非叶子节点开始向下调整）
    public void createHeap() {
        // 最后一个非叶子节点的下标
        int root = (this.usedSize - 1 - 1) / 2;

        for (; root >= 0; root--) {
            // 向下调整
            siftDown(root, this.usedSize);
        }
    }

    // 插入元素
    public void offer(int val) {
        // 判断容量是否已满
        if (isFull()) {
            // 扩容
            grow();
        }

        // 将数据插入到最后
        this.elem[this.usedSize] = val;

        // 向上调整
        siftUp(this.usedSize);

        this.usedSize++;
    }

    // 删除堆顶元素
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("堆为空，无法删除元素");
        }

        int ret = this.elem[0];  // 保存堆顶元素

        // 堆顶元素与堆中最后一个元素交换
        swap(0, this.usedSize - 1);
        this.usedSize--;

        // 堆顶元素向下调整
        siftDown(0, this.usedSize);

        // 返回删除元素
        return ret;
    }

    // 查看堆顶元素（不删除）
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("堆为空，无法查看堆顶元素");
        }
        return this.elem[0];
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 堆排序（升序）
    public void heapSort() {
        int end = this.usedSize - 1;

        while (end > 0) {
            swap(0, end);
            siftDown(0, end);
            end--;
        }
    }

    // 获取堆的数组表示（用于测试）
    public int[] toArray() {
        return Arrays.copyOf(this.elem, this.usedSize);
    }

}
