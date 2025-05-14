public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTree.BTNode root = binaryTree.createTree();

        binaryTree.preOrder(root);
        System.out.println();

        binaryTree.inOrder(root);
        System.out.println();

        binaryTree.postOrder(root);
        System.out.println();

        System.out.println("树的节点个数：" + binaryTree.size1(root));

        System.out.println("树的节点个数：" + binaryTree.size2(root));

        System.out.println("叶子节点的个数：" + binaryTree.getLeafNodeCount1(root));

        System.out.println("叶子节点的个数：" + binaryTree.getLeafNodeCount2(root));

        System.out.println("第 3 层的节点个数：" + binaryTree.getKLevelNodeCount(root, 3));

        System.out.println("树的高度：" + binaryTree.getHeight(root));

        BinaryTree.BTNode ret = binaryTree.find(root, 'E');

        if (ret == null) {
            System.out.println("树中查无该元素");
        } else {
            System.out.println("找到元素: " + ret.value);
        }
    }
}
