public class BinaryTree {
    public static class BTNode {
        char value;
        BTNode left;
        BTNode right;

        BTNode(char data) {
            this.value = data;
        }
    }

    private BTNode Root; //根


    //创建临时二叉树
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = F;
        C.right = G;

        E.right = H;

        return A;

    }


    //前序遍历
    public void preOrder(BTNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder((root.right));

    }

    //中序遍历
    public void inOrder(BTNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);

    }

    //后序遍历
    public void postOrder(BTNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    //获取树中节点的个数(遍历思路)
    private int size = 0;

    public int size1(BTNode root) {
        if (root == null) {
            return 0;
        }

        this.size++;
        size1(root.left);
        size1(root.right);

        return this.size;
    }

    //获取树中节点个数(子问题思路)
    public int size2(BTNode root) {
        if (root == null) {
            return 0;
        }

        return size2(root.left) + size2(root.right) + 1;
    }

    //获取叶子节点的个数(遍历思路)
    private int leafNodeCount = 0;

    public int getLeafNodeCount1(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            this.leafNodeCount++;
        }

        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);

        return this.leafNodeCount;
    }

    //获取叶子节点个数(子问题思路)
    public int getLeafNodeCount2(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    //获取第 k 层 节点个数
    public int getKLevelNodeCount(BTNode root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLevelNodeCount(root.left, k - 1) +
                getKLevelNodeCount(root.right, k - 1);
    }

    //获取二叉树的高度
    public int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }
}
