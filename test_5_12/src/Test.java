import java.util.List;

public class Test {
    public static void main(String[] args) {
        BinaryTree BT = new BinaryTree();
        BinaryTree.BTNode root = BT.createTree();

        List<BinaryTree.BTNode> ret1 = BT.preOrder(root);
        System.out.print("前序遍历: ");
        for (BinaryTree.BTNode x : ret1) {
            System.out.print(x.value + " ");
        }
        System.out.println();

        List<BinaryTree.BTNode> ret2 = BT.inOrder(root);
        System.out.print("中序遍历: ");
        for (BinaryTree.BTNode x :
             ret2) {
            System.out.print(x.value + " ");
        }
        System.out.println();

        List<BinaryTree.BTNode> ret3 = BT.postOrder(root);
        System.out.print("后序遍历: ");
        for (BinaryTree.BTNode x :
             ret3) {
            System.out.print(x.value + " ");
        }
        System.out.println();

        System.out.println("节点的个数: " + BT.size(root));

        //获取叶子节点的个数
        System.out.println("叶子节点的个数: " + BT.getLeafNodeCount(root));

        //子问题 —— 叶子节点个数
        System.out.println("叶子节点的个数: " + BT.getLeafNodeCount1(root));

        //子问题 —— 获取第 K 层 节点个数
        System.out.println("第 3 层节点个数: " + BT.getKLevelNodeCount(root, 3));

        //树的高度
        System.out.println("树的高度: " + BT.getHeight(root));


    }
}
