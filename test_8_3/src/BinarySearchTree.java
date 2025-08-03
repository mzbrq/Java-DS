public class BinarySearchTree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    private TreeNode root;
    //查找
    public TreeNode search(int value) {
        TreeNode cur = this.root;

        while (cur != null) {
            if (cur.val < value) {
                cur = cur.right;
            } else if (cur.val > value) {
                cur = cur.left;
            } else {
                return cur;
            }
        }

        return null;
    }

    //插入
    public boolean insert(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
            return true;
        }

        TreeNode curParent = null;
        TreeNode cur = this.root;

        while (cur != null) {
            if (cur.val < value) {
                curParent = cur;
                cur = cur.right;
            } else if (cur.val > value) {
                curParent = cur;
                cur = cur.left;
            } else {
                System.out.println("value 已经存在");
                return false;
            }
        }

        TreeNode newNode = new TreeNode(value);

        if (curParent.val < value) {
            curParent.right = newNode;
        } else {
            curParent.left = newNode;
        }

        return true;
    }

    //删除
    public boolean remove(int value) {
        TreeNode curParent = null;
        TreeNode cur = this.root;

        while (cur != null) {
            if (value > cur.val) {
                curParent = cur;
                cur = cur.right;
            } else if (value < cur.val) {
                curParent = cur;
                cur = cur.left;
            } else {
                removeNode(curParent, cur);
                return true;
            }
        }

        return false;
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (cur == this.root) {
                this.root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == this.root) {
                this.root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            TreeNode targetParent = cur;
            TreeNode target = cur.left;

            while (target.right != null) {
                targetParent = target;
                target = target.right;
            }

            cur.val = target.val;

            if (targetParent.left == target) {
                targetParent.left = target.left;
            } else {
                targetParent.right = target.left;
            }
        }
    }

}
