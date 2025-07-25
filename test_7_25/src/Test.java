public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);

        BinarySearchTree.TreeNode root = binarySearchTree.getRoot();
        binarySearchTree.inOderTraversal(root);
        System.out.println();

        System.out.println(binarySearchTree.search(3));
        System.out.println(binarySearchTree.search(6));

        binarySearchTree.remove(4);
        binarySearchTree.inOderTraversal(root);
        System.out.println();

        binarySearchTree.remove(1);
        binarySearchTree.inOderTraversal(root);
        System.out.println();

        binarySearchTree.remove(3);
        binarySearchTree.inOderTraversal(root);
        System.out.println();

        binarySearchTree.remove(2);
        binarySearchTree.inOderTraversal(root);
        System.out.println();

        binarySearchTree.remove(5);
        BinarySearchTree.TreeNode root2 = binarySearchTree.getRoot();
        binarySearchTree.inOderTraversal(root2);
        //System.out.println();

    }
}
