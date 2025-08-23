public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //平衡二叉树
    public boolean isBalanced(TreeNode root) {
        // if (root == null) return true;

        // int left = getHeight(root.left);
        // int right = getHeight(root.right);

        // if (Math.abs(left-right) > 1) {
        //     return false;
        // }

        // boolean flg1 = isBalanced(root.left);
        // boolean flg2 = isBalanced(root.right);

        // return flg1 && flg2;
        return getHeight(root) >= 0;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left_height = getHeight(root.left);
        int  right_height = getHeight(root.right);

        if (left_height == -1 || right_height == -1 || Math.abs(left_height-right_height) > 1) {
            return -1;
        }

        return Math.max(left_height, right_height) + 1;
    }

    //二叉树后序遍历迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right != null && top.right != prev) {
                //stack.push(top.right);
                cur = top.right;
            } else {
                ret.add(top.val);
                prev = stack.pop();

            }
        }

        return ret;

    }
}
