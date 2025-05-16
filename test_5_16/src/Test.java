public class Test {
    public static void main(String[] args) {
        System.out.println("二叉树刷题");
    }

    //判断树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q){
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        //都为空，为true
        if (p == null && q == null) {
            return true;
        }

        //都不为空，比较值
        if (q.val != p.val) {
            return false;
        }



        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }


    //另一颗树的子树
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        if (isSubtree(root.left, subRoot)) {
            return true;
        }

        if (isSubtree(root.right, subRoot)) {
            return true;
        }

        return false;

    }
}
