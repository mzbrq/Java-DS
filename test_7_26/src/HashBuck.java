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

    Node[] array;
    int usedSize;

    public HashBuck() {
        this.array = new Node[10];
    }

    //插入
    public void put(int key, int value) {
        int index = key % this.array.length;
        //根据 key值 与 数组下标对应关系 找到存放位置
        Node cur = this.array[index];

        //先遍历链表，查看 value 是否存在
        while (cur != null) {
            if (cur.key == key) {
                //key 已存在: 修改节点value 即可
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        //链表不存在key
        cur = this.array[index];

        //头插法插入
        Node newNode = new Node(key, value);
        newNode.next = cur;
        this.array[index] = newNode;
        this.usedSize++;

        //判断负载因子 是否大于 0.75
        if (loadFactor() > 0.75) {
            //需要扩容
            resize();
        }

    }

    private void resize() {
        Node[] tmpArr = new Node[2*this.array.length];

        //把数组中元素 重新哈希进 新的数组
        for (int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];

            while (cur != null) {
                //头插
                Node curNext = cur.next; // 记录当前节点的下一个
                int newIndex = cur.key % tmpArr.length;

                cur.next = tmpArr[newIndex];
                tmpArr[newIndex] = cur;

                cur = curNext;
            }
        }

        this.array = tmpArr;
    }

    private double loadFactor() {
        return this.usedSize*1.0 / this.array.length;
    }

    //get方法
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
