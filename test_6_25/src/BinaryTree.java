import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class BTNode {
        char value; //元素
        BTNode left; //根的左节点
        BTNode right; //根的右节点

        BTNode(char value) {
            this.value = value;
        }
    }

    //根节点
    private BTNode Root;


    //创建一颗临时二叉树
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');

        //链接
        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = F;
        C.right = G;

        E.left = H;

        this.Root = A;

        return A;

    }


    //前序遍历
    public void preOrder(BTNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);

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

    //获取树中节点个数（遍历思想）
    private int size1 = 0;

    public int size1(BTNode root) {
        if (root == null) {
            return 0;
        }

        this.size1++;
        size1(root.left);
        size1(root.right);

        return this.size1;
    }

    //获取树中节点个数（递归思想）
    public int size2(BTNode root) {
        if (root == null) {
            return 0;
        }

        int left = size2(root.left);
        int right = size2(root.right);

        return left + right + 1;
    }

    //获取叶子节点的个数（遍历思想）

    private int count;
    public int getLeafNodeCount1(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            this.count++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);

        return this.count;
    }

    //树中叶子节点的个数（递归思想）
    public int getLeafNodeCount2(BTNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftCount = getLeafNodeCount2(root.left);
        int rightCount = getLeafNodeCount2(root.right);

        return leftCount + rightCount;
    }

    //获取第 k 层节点个数
    public int getKLevelNodeCount(BTNode root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLevelNodeCount(root.left, k-1) + getKLevelNodeCount(root.right, k-1);
    }


    //获取二叉树的高度（遍历思想）
    public int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    //查找 树中value是否存在
    public BTNode find(BTNode root, char value) {
        if (root == null) {
            return null;
        }

        if (root.value == value) {
            return root;
        }

        BTNode left = find(root.left, value);
        if (left != null) {
            return left;
        }
        BTNode right = find(root.right, value);
        if (right != null) {
            return right;
        }

        return null;
    }

    //层序遍历
    public void levelOrder(BTNode root) {
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTNode tmp = queue.poll();

            System.out.print(tmp.value + " ");

            if (tmp.left != null) {
                queue.offer(tmp.left);
            }

            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
    }

    //判断一颗树是不是完全二叉树
    public boolean isCompleteTree(BTNode root) {
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTNode tmp = queue.poll();

            if (tmp == null) {
                break;
            }

            queue.offer(tmp.left);

            queue.offer(tmp.right);

        }

        while (!queue.isEmpty()) {
            BTNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }

        return true;
    }


}
