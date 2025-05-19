public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode() {};

    TreeNode(char value) {
        this.val = value;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();

            TreeNode root = createTree(str);

            inOrder(root);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static int i = 0;

    public static TreeNode createTree(String str) {
        char ch = str.charAt(i);
        TreeNode root = null;

        if (ch != '#') {
            root = new TreeNode(ch);
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        } else {
            i++;
        }

        return root;
    }
}
