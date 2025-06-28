public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }


    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric1(root.left, root.right);
    }
    public boolean isSymmetric1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetric1(left.left, right.right) &&
                    isSymmetric1(left.right, right.left);
        }
    }

    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

        return list;
    }


    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postorder(root, list);

        return list;
    }

    public List<Integer> postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        postorder(root.left, list);
        postorder(root.right, list);

        list.add(root.val);

        return list;
    }



}
