public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //根据二叉树创建字符串
    public String tree2str(TreeNode root) {
        StringBuilder stringBuild = new StringBuilder();
        tree2strChild(root, stringBuild);
        return stringBuild.toString();
    }

    private void tree2strChild(TreeNode root, StringBuilder stringBuild) {
        if (root == null) {
            return;
        }

        stringBuild.append(root.val);

        if (root.left != null) {
            stringBuild.append("(");
            tree2strChild(root.left, stringBuild);
            stringBuild.append(")");
        } else {
            if (root.right != null) {
                stringBuild.append("()");
            } else {
                return;
            }
        }

        if (root.right != null) {
            stringBuild.append("(");
            tree2strChild(root.right, stringBuild);
            stringBuild.append(")");
        } else {
            return;
        }
    }


    //非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode top = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            top = stack.pop();
            list.add(top.val);
            cur = top.right;
        }

        return list;
    }


    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode top = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }

            top = stack.pop();
            cur = top.right;
        }

        return list;
    }

    //前中序遍历序列创建二叉树
    private int preBigin;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeChild(int[] preorder, int[] inorder, int inBigin, int inEnd) {
        //判断有无左右子树
        if (inBigin > inEnd) {
            return null;
        }

        //创建节点
        TreeNode root = new TreeNode(preorder[preBigin]);

        //找到根节点中序遍历中的下标
        int index = findIndex(inorder, inBigin, inEnd, preorder[preBigin]);

        if (index == -1) {
            return null;
        }

        preBigin++;


        root.left = buildTreeChild(preorder, inorder, inBigin, index-1);
        root.right = buildTreeChild(preorder, inorder, index+1, inEnd);

        return root;
    }

    private int findIndex(int[] inorder, int inBigin, int inEnd, int key) {
        for (int i = inBigin; i <= inEnd; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
