public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getHeight(root) >= 0;


    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left >= 0 && right >= 0 && Math.abs(left-right) <= 1) {
            return Math.max(left, right)+1;
        } else {
            return -1;
        }
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric1(root.left, root.right);


    }

    public boolean isSymmetric1(TreeNode root1, TreeNode root2) {
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetric1(root1.left, root2.right) && isSymmetric1(root1.right, root2.left);
    }
}
