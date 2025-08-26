public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        } else if (root == null) {
            return null;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else if (left == null) {
                return right;
            } else {
                return left;
            }
        }

    }

    //后续遍历非递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();

            if (top.right == null || top.right == prev) {
                prev = stack.pop();
                list.add(prev.val);
            } else {
                cur = top.right;
            }
        }
        return list;
    }
}
