public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
    private Node[] array;
    private int size;//当前数据个数
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 10;//默认桶的大小

    HashBucket() {
        this.array = new Node[DEFAULT_SIZE];
    }

    //插入
    public int put(int key, int value) {
        int index = key % this.array.length;
        Node cur = this.array[index];

        while (cur != null) {
            if (cur.key == key) {
                //key 已经存在，修改 value
                cur.value = value;
                return cur.value;
            }
            cur = cur.next;
        }

        //key 不存在
        Node newNode = new Node(key, value);

        //头插法，插入数组
        newNode.next = this.array[index];
        this.array[index] = newNode;
        this.size++;

        //判断 负载因子 是否 超过 LOAD_FACTOR
        if (loadFactor() > LOAD_FACTOR) {
            //扩容
            resize();
        }

        return value;
    }

    private double loadFactor() {
        return this.size*1.0 / this.array.length;
    }

    private void resize() {
        Node[] tmpArr = new Node[2*this.array.length];

        //把数据重新哈希进 新的数组
        for (int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];

            while (cur != null) {
                Node curNext = cur.next;

                int newIndex = cur.key % tmpArr.length;
                //头插法， 插入新的数组中
                cur.next = tmpArr[newIndex];
                tmpArr[newIndex] = cur;

                cur = curNext;
            }
        }

        this.array = tmpArr;
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

        System.out.println("找不到 key = " + key);
        return -1;
    }


}
