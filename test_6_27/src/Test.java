public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }


    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    //翻转二叉树
    public void reverse(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        reverse(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }


    //另一颗树的子树
    public void reverse(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        reverse(root);
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
