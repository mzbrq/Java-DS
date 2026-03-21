public class Main {
    public static void main(String[] args) {
        System.out.println("=== 测试小顶堆实现 ===\n");

        // 测试1：基本功能测试
        System.out.println("1. 基本功能测试");
        MyHeap heap1 = new MyHeap();
        int[] arr1 = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        heap1.initHeap(arr1);
        heap1.createHeap();

        System.out.println("   初始化数组: " + arrayToString(arr1));
        System.out.println("   堆顶元素(最小值): " + heap1.peek());

        // 测试2：插入元素
        System.out.println("\n2. 插入元素测试");
        heap1.offer(10);
        System.out.println("   插入10后堆顶元素: " + heap1.peek());

        heap1.offer(5);
        System.out.println("   插入5后堆顶元素: " + heap1.peek());

        // 测试3：删除元素（按升序删除）
        System.out.println("\n3. 删除元素测试（按升序输出）");
        System.out.print("   ");
        while (!heap1.isEmpty()) {
            System.out.print(heap1.poll() + " ");
        }
        System.out.println();

        // 测试4：堆排序测试
        System.out.println("\n4. 堆排序测试");
        MyHeap heap2 = new MyHeap();
        int[] arr2 = {77, 53, 80, 62, 78, 29, 28, 66, 57, 100};
        heap2.initHeap(arr2);
        heap2.createHeap();

        System.out.println("   排序前堆数组: " + arrayToString(arr2));
        heap2.heapSort();

        // 获取排序后的数组
        int[] sortedArr = heap2.toArray();
        System.out.println("   排序后数组: " + arrayToString(sortedArr));

        // 测试5：边界测试
        System.out.println("\n5. 边界测试");
        MyHeap heap3 = new MyHeap(3); // 小容量测试
        System.out.println("   创建容量为3的堆");

        heap3.offer(30);
        heap3.offer(20);
        heap3.offer(10);
        System.out.println("   插入3个元素后堆顶: " + heap3.peek());

        heap3.offer(5); // 触发扩容
        System.out.println("   插入第4个元素（触发扩容）后堆顶: " + heap3.peek());

        // 测试6：异常测试
        System.out.println("\n6. 异常测试");
        MyHeap emptyHeap = new MyHeap();
        System.out.println("   空堆是否为空: " + emptyHeap.isEmpty());

        try {
            emptyHeap.peek();
        } catch (RuntimeException e) {
            System.out.println("   空堆peek()抛出异常: " + e.getMessage());
        }

        try {
            emptyHeap.poll();
        } catch (RuntimeException e) {
            System.out.println("   空堆poll()抛出异常: " + e.getMessage());
        }

        System.out.println("\n=== 所有测试完成 ===");
    }

    // 辅助方法：数组转字符串
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}