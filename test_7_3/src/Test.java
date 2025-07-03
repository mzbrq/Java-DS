public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        TreeNode top = null;
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            top = stack.peek();

            if (top.right == null || top.right == prev) {
                stack.pop();
                list.add(top.val);
                prev = top;
            } else {
                cur = top.right;
            }
        }

        return list;
    }
}
