import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    public static class BTNode {
        int value;
        private BTNode left;
        private BTNode right;

        BTNode(int value) {
            this.value = value;
        }
    }

    private BTNode Root;

    //创建临时二叉树
    public BTNode createTree() {
        BTNode A = new BTNode(1);
        BTNode B = new BTNode(2);
        BTNode C = new BTNode(3);
        BTNode D = new BTNode(4);
        BTNode E = new BTNode(5);
        BTNode F = new BTNode(6);
        BTNode G = new BTNode(7);
        BTNode H = new BTNode(8);

        this.Root = A;
        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        E.right = H;

        C.left = F;
        C.right = G;

        return A;
    }


    //前序遍历
    public List<BTNode> preOrder(BTNode root) {
        List<BTNode> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        //System.out.print(root.value + " ");
        ret.add(root);

        List<BTNode> leftTree = preOrder(root.left);
        ret.addAll(leftTree);

        List<BTNode> rightTree = preOrder(root.right);
        ret.addAll(rightTree);

        return ret;
    }

    //中序遍历
    public List<BTNode> inOrder(BTNode root) {
        List<BTNode> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        List<BTNode> leftTree = inOrder(root.left);
        //System.out.print(root.value + " ");
        ret.addAll(leftTree);

        ret.add(root);

        List<BTNode> rightTree = inOrder(root.right);
        ret.addAll(rightTree);

        return ret;


    }

    //后序遍历
    public List<BTNode> postOrder(BTNode root) {
        List<BTNode> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }

        List<BTNode> leftTree = postOrder(root.left);
        ret.addAll(leftTree);

        List<BTNode> rightTree = postOrder(root.right);
        ret.addAll(rightTree);

        //System.out.print(root.value + " ");
        ret.add(root);

        return ret;
    }

    //计算节点中的个数
    public int size(BTNode root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }

    //获取叶子节点的个数
    private int leafNodeCount = 0;

    public int getLeafNodeCount(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            leafNodeCount++;
        }

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);

        return leafNodeCount;
    }

    //使用子问题思想——获取叶子节点个数
    public int getLeafNodeCount1(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCount1(root.left) + getLeafNodeCount1(root.right);
    }

    //获取 k 层节点的个数(子问题思想)
    public int getKLevelNodeCount(BTNode root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLevelNodeCount(root.left, k-1) + getKLevelNodeCount(root.right, k-1);
    }

    //获取树的高度
    public int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return left > right ? left+1 : right+1;


    }
}
