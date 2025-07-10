import java.util.Arrays;

public class TestHeap {
    private int[] elem;
    private int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
    }

    public void createHeap() {
        for (int parent = (this.usedSize-1-1) / 2; parent >= 0; parent--) {
            shiftDown(parent);
        }
    }

    private void shiftDown(int parent) {
        int child = parent*2 + 1;

        while (child < this.usedSize) {
            //找到最大孩子节点的下标
            if (child+1 < this.usedSize && this.elem[child] < this.elem[child+1]) {
                child++;
            }

            if (this.elem[parent] < this.elem[child]) {
                //交换
                swap(parent, child);
                //迭代
                parent = child;
                child = parent*2 + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int p, int c) {
        int tmp = this.elem[p];
        this.elem[p] = this.elem[c];
        this.elem[c] = tmp;
    }

    //插入
    public void offer(int val) {
        //判断容量
        if (isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }

        this.elem[this.usedSize] = val;

        //向上调整
        shiftUp(this.usedSize);

        this.usedSize++;

    }

    private void shiftUp(int child) {
        int parent = (child-1)/2;

        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                //交换
                swap(child, parent);
                //迭代
                child = parent;
                parent = (child-1)/2;
            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }


    //删除
    public int poll() {
        int tmp = this.elem[0];

        //0下标元素与数组尾元素交换
        swap(0, this.usedSize-1);

        //删除
        this.usedSize--;

        //向下调整
        shiftDown(0);

        return tmp;
    }

    public int peek() {
        return this.elem[0];
    }
}
