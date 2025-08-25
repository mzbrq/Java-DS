public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //二叉数层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size != 0) {
                TreeNode head = queue.poll();
                list.add(head.val);

                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }

                size--;
            }

            ret.add(0, list);
        }

        return ret;
    }

    //前序遍历非递归

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
