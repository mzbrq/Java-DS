import java.time.chrono.MinguoDate;

public class HashBuck {
    static class Node {
        private int key;
        private int value;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array;
    private int usedSize;

    HashBuck() {
        this.array = new Node[10];
    }


    //插入
    public void put(int key, int value) {
        //判断哈希表中key 是否存在
        int index = key % this.array.length;

        Node cur = this.array[index];

        while (cur != null) {
            if (cur.key == key) {
                //key已经存在
                cur.value = value;
                return;
            }

            cur = cur.next;
        }

        //头插
        Node newNode = new Node(key, value);
        newNode.next = this.array[index];
        this.array[index] = newNode;
        this.usedSize++;

        //判断负荷因子是否过高
        if (loadFactor() > 0.75) {
            //扩容
            resize();
        }
    }

    private void resize() {
        Node[] tmpArray = new Node[2*this.array.length];

        for (int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];
            while (cur != null) {
                int newIndex = cur.key % tmpArray.length;
                Node curNext = cur.next;

                //头插
                cur.next = tmpArray[newIndex];
                tmpArray[newIndex] = cur;

                cur = curNext;
            }
        }

        this.array = tmpArray;
    }

    private double loadFactor() {
        return this.usedSize*1.0 / this.array.length;
    }

    public int get(int key) {
        int index = key % this.array.length;

        Node cur = this.array[index];

        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }

            cur = cur.next;
        }

        return -1;
    }
}
