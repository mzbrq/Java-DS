public class Test {
    public static void main(String[] args) {
        System.out.println("二叉树两个节点的最近公共祖先");
    }
}

    public boolean getPath(TreeNode root, TreeNode key, Stack<TreeNode> stack) {
        if (root == null || key == null) {
            return false;
        }

        stack.push(root);

        if (root.equals(key)) {
            return true;
        }

        boolean flg1 = getPath(root.left, key, stack);
        if (flg1) {
            return true;
        }

        boolean flg2 = getPath(root.right, key, stack);
        if (flg2) {
            return true;
        }

        stack.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stackP = new Stack();
        Stack<TreeNode> stackQ = new Stack();

        getPath(root, p, stackP);
        getPath(root, q, stackQ);

        //判断两个栈中的个数差值
        int sizeP = stackP.size();
        int sizeQ = stackQ.size();

        if (sizeP > sizeQ) {
            int size = sizeP - sizeQ;
            while (size != 0) {
                stackP.pop();
                size--;
            }
        } else {
            int size = sizeQ - sizeP;
            while (size != 0) {
                stackQ.pop();
                size--;
            }
        }

        //求公共祖先
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            if (stackP.peek().equals(stackQ.peek())) {
                return stackP.pop();
            }

            stackP.pop();
            stackQ.pop();
        }

        return null;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
