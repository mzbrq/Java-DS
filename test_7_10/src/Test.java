public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] arr = { 27,15,19,18,28,34,65,49,25,37 };
        testHeap.initHeap(arr);
        testHeap.createHeap();

        System.out.println();

        //插入
        //testHeap.offer(80);

        System.out.println("========");

        //删除
        int ret = testHeap.poll();
        System.out.println(ret);

        System.out.println("========");

        System.out.println(testHeap.peek());

        System.out.println("========");
    }
}
