public class TestHeap {
    private int[] elem;
    private int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void intiHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
    }

    public void createHeap() {
        for (int parent = (this.usedSize-1-1)/2; parent >= 0; parent--) {
            //向下调整
            shiftDown(parent);
        }
    }

    private void shiftDown(int parent) {
        int child = parent*2 + 1;

        while (child < this.usedSize) {
            //确定左右孩子节点中最大值的下标
            if (child+1 < this.usedSize && this.elem[child] < this.elem[child+1]) {
                child++;
            }

            if (this.elem[parent] < this.elem[child]) {
                //交换
                swap(parent, child);
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


}
