public class TestHeap {
    private int[] elem;
    private int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
    }

    public void createHeap() {
        for (int parent = (this.usedSize-1-1)/2; parent >= 0; parent--) {
            shiftDown(parent);
        }
    }

    //向下调整
    private void shiftDown(int parent) {
        int child = (parent*2)+1;

        while (child < usedSize) {
            if (child+1 < this.usedSize && this.elem[child] < this.elem[child+1]) {
                child++;
            }

            if (this.elem[parent] < this.elem[child]) {
                //交换
                swap(parent, child);
                //迭代
                parent = child;
                child = (parent*2)+1;
            } else {
                //已经是大根堆
                break;
            }
        }
    }

    private void swap(int p, int c) {
        int tmp = this.elem[p];
        this.elem[p] = this.elem[c];
        this.elem[c] = tmp;
    }


}
