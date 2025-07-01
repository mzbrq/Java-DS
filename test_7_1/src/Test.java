public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }


    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curRoot = queue.poll();
                level.add(curRoot.val);

                if (curRoot.left != null) {
                    queue.offer(curRoot.left);
                }

                if (curRoot.right != null) {
                    queue.offer(curRoot.right);
                }
            }

            list.add(level);
        }

        return list;
    }



    //找到两节点最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null && rightNode == null) {
            return leftNode;
        } else {
            return rightNode;
        }
    }
}
