public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] arr = {77, 53, 80, 62, 78, 29, 28, 66, 57, 100};

        testHeap.initHeap(arr);

        testHeap.createHeap();

        //插入
        System.out.println("==== 插入 ====");
        testHeap.offer(40);

        //删除
        System.out.println("==== 删除 ====");
        System.out.println(testHeap.poll());

        //peek
        System.out.println("==== peek ====");
        System.out.println(testHeap.peek());

        //堆排序
        testHeap.heapSort();


    }
}
