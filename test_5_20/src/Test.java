public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> list = new LinkedList();

        if (root == null) {
            return list;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new LinkedList();

            while (size != 0) {
                TreeNode cur = queue.poll();

                tmp.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                size--;
            }

            list.add(tmp);
        }

        return list;
    }
}
