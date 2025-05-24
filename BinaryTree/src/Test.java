public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTree.TreeNode root = binaryTree.createTreeNode();

        binaryTree.preOrder(root);
        System.out.println();

        binaryTree.inOrder(root);
        System.out.println();

        binaryTree.postOrder(root);
        System.out.println();

        System.out.println("树中节点个数：" + binaryTree.size1(root));

        System.out.println("树中节点个数：" + binaryTree.size2(root));

        System.out.println("树中叶子节点的个数：" + binaryTree.getLeafNodeCount1(root));

        System.out.println("树中叶子节点的个数：" + binaryTree.getLeafNodeCount2(root));

        System.out.println("第 3 层的节点个数：" + binaryTree.getKLevelCount(root, 3));

        System.out.println("树的高度：" + binaryTree.getHeight(root));

        BinaryTree.TreeNode node = binaryTree.find(root, 'A');
        if (node == null) {
            System.out.println("树中没有该元素");
        } else {
            binaryTree.preOrder(node);
            System.out.println();
        }

        binaryTree.levelOrder(root);
        System.out.println();

        if (binaryTree.isCompleteTree(root)) {
            System.out.println("是完全二叉树");
        } else {
            System.out.println("不是完全二叉树");
        }


    }
}
