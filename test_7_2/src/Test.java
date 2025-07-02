public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //根据前序和中序遍历创建二叉树
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

    //二叉树的最近公共祖先


    // if (root == null) {
    //     return null;
    // }

    // if (p == root || q == root) {
    //     return root;
    // }

    // TreeNode flg1 = lowestCommonAncestor(root.left, p, q);

    // TreeNode flg2 = lowestCommonAncestor(root.right, p, q);

    // if (flg1 != null && flg2 != null) {
    //     return root;
    // } else if (flg1 == null) {
    //     return flg2;
    // } else {
    //     return flg1;
    // }
    Stack<TreeNode> stackP = new Stack<TreeNode>();
    Stack<TreeNode> stackQ = new Stack<TreeNode>();

    getPath(root, p, stackP);
    getPath(root, q, stackQ);

    int sizeP = stackP.size();
    int sizeQ = stackQ.size();

    int i = Math.abs(sizeP - sizeQ);

        if (sizeP > sizeQ) {
        while (i > 0) {
            stackP.pop();
            i--;
        }
    } else {
        while (i > 0) {
            stackQ.pop();
            i--;
        }
    }


        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
        if (stackP.peek().equals(stackQ.peek())) {
            return stackP.pop();
        }

        stackP.pop();
        stackQ.pop();
    }

        return null;

}

    public boolean getPath(TreeNode root, TreeNode node, Stack stack) {
        if (root == null || node == null) {
            return false;
        }

        stack.push(root);

        if (root == node) {
            return true;
        }

        boolean flg1 = getPath(root.left, node, stack);

        if (flg1) {
            return true;
        }

        boolean flg2 = getPath(root.right, node, stack);

        if (flg2) {
            return true;
        }

        stack.pop();

        return false;
    }
}
