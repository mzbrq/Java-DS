import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(10);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(7);



        binarySearchTree.inOrder(binarySearchTree.getRoot());
        System.out.println();

        binarySearchTree.remove(8);
        binarySearchTree.inOrder(binarySearchTree.getRoot());
        System.out.println();

        binarySearchTree.remove(0);
        binarySearchTree.inOrder(binarySearchTree.getRoot());
        System.out.println();

        binarySearchTree.remove(5);
        binarySearchTree.inOrder(binarySearchTree.getRoot());
        System.out.println();


        //Map 的使用
        System.out.println("==============");

        Map<String, Integer> map1 = new TreeMap<>();
        map1.put("hahaha", 12);
        map1.put("linx", 32);
        map1.put("Bianry", 22);
        map1.put("return", 18);
        map1.put("xiaoming", 21);
        map1.put("xiaohong", 19);


        System.out.println(map1.get("linx"));
        System.out.println(map1.get("lin"));

        map1.remove("linx");

        Set<Map.Entry<String, Integer>> entries = map1.entrySet();

        for (Map.Entry<String, Integer> entry:
             entries) {
            System.out.println("key: " + entry.getKey() + " ,value：" + entry.getValue());
        }


        //hashBuck 插入模拟实现
        System.out.println("================");
        HashBuck hashBuck = new HashBuck();

        hashBuck.put(1, 1);
        hashBuck.put(11, 11);
        hashBuck.put(13, 13);
        hashBuck.put(8, 8);
        hashBuck.put(6, 6);
        hashBuck.put(3, 3);
        hashBuck.put(7, 7);
        hashBuck.put(4, 4);
        System.out.println();

        System.out.println(hashBuck.get(11));
        System.out.println(hashBuck.get(39));


    }
}
