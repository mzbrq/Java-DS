public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //遍历二叉树创建字符串
    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder s1 = new StringBuilder();
        s1.append(root.val);

        if (root.left == null && root.right != null) {
            s1.append("()");
        }
        tree2strChild(root.left, s1);
        tree2strChild(root.right, s1);

        return s1.toString();


    }

    public void tree2strChild(TreeNode root, StringBuilder s) {
        if (root == null) {
            return;
        } else if (root != null) {
            s.append('(');
            s.append(root.val);

        }

        if (root.left == null && root.right != null) {
            s.append("()");
        }

        tree2strChild(root.left, s);

        tree2strChild(root.right, s);

        s.append(')');
    }
}
