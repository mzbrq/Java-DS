public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(6);
        bst.insert(2);
        bst.insert(5);
        bst.insert(9);
        System.out.println();

        System.out.println(bst.search(6));
        System.out.println(bst.search(2));
        System.out.println(bst.search(5));
        System.out.println(bst.search(9));
        System.out.println(bst.search(1));
        System.out.println();

        System.out.println(bst.remove(6));
        System.out.println(bst.remove(9));
        System.out.println(bst.remove(5));
        System.out.println(bst.remove(2));
        System.out.println(bst.remove(1));



    }
}
