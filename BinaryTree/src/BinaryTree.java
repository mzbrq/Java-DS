import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class TreeNode {
        private char val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }

        public TreeNode() {};
    }

    private TreeNode Root;

    //创建临时二叉树
    public TreeNode createTreeNode() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = F;
        C.right = G;

        E.right = H;

        this.Root = A;

        return A;

    }


    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //获取树中节点的个数(遍历思想)
    private static int size = 0;
    public int size1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        size++;
        size1(root.left);
        size1(root.right);

        return size;
    }

    //获取树中节点个数(递归思想)
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = size2(root.left);
        int right = size2(root.right);

        return left + right + 1;
    }

    //获取树中叶子节点的个数(遍历思想)
    private static int count = 0;
    public int getLeafNodeCount1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            count++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);

        return count;
    }

    //获取树中叶子节点的个数(递归思想)
    public int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    //求第 k 层节点的个数(递归思想)
    public int getKLevelCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }

        return getKLevelCount(root.left, k-1) + getKLevelCount(root.right, k-1);

    }


    //获取二叉树的高度(遍历思想)
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return left > right ? left+1 : right+1;
    }

    //查找树中是否存在 value
    public TreeNode find(TreeNode root, char value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode left = find(root.left, value);
        if (left != null) {
            return left;
        }

        TreeNode right = find(root.right, value);
        if (right != null) {
            return right;
        }

        return null;

    }


    //层序遍历
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur == null) {
                break;
            }

            queue.offer(cur.left);
            queue.offer(cur.right);

        }


        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur != null) {
                return false;
            }
        }

        return true;
    }
}
