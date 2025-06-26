public class Test {
    public static void main(String[] args) {
        BinaryTree BTree = new BinaryTree();

        BinaryTree.BTNode root = BTree.createTree();

        BTree.preOrder(root);

        System.out.println();

        BTree.inOrder(root);

        System.out.println();

        BTree.postOrder(root);

        System.out.println();

        System.out.println("树中节点个数: " + BTree.size1(root));
        System.out.println("树中节点个数：" + BTree.size2(root));

        System.out.println("树中叶子节点的个数: " + BTree.getLeafNodeCount1(root));
        System.out.println("树中叶子节点的个数: " + BTree.getLeafNodeCount2(root));

        System.out.println("第 k 层节点个数: " + BTree.getKLevelNodeCount(root, 1));

        System.out.println("树的高度: " + BTree.getHeight(root));

        BinaryTree.BTNode node = BTree.find(root, 'H');
        if (node == null) {
            System.out.println("树中不包含 value");
        } else {
            System.out.println("树中包含 value = " + node.value);
        }

        BTree.levelOrder(root);
        System.out.println();

        if (BTree.isCompleteTree(root)) {
            System.out.println("完全二叉树");
        } else {
            System.out.println("非完全二叉树");
        }


    }
}
