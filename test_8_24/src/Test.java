public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }


    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;

        }

        return ret;
    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ret;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            ret.add(top.val);

            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }

        }

        return ret;
    }
}
