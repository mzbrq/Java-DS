public class BinarySearchTree {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

    public TreeNode getRoot() {
        return Root;
    }

    private TreeNode Root;


    //搜索
    public boolean search(int value) {
        TreeNode cur = this.Root;

        while (cur != null) {
            if (cur.val < value) {
                cur = cur.left;
            } else if (cur.val > value) {
                cur = cur.right;
            } else {
                return true;
            }
        }

        return false;
    }
    //插入

    public boolean insert(int value) {
        if (this.Root == null) {
            this.Root = new TreeNode(value);
            return true;
        }

        TreeNode newNode = new TreeNode(value);
        TreeNode parent = null;
        TreeNode cur = this.Root;

        while (cur != null) {
            if (cur.val < value) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > value) {
                parent = cur;
                cur = cur.left;
            } else {
                return false;
            }
        }

        if (parent.val < value) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        return true;
    }

    //删除
    public void remove(int value) {
        //找到删除节点位置
        TreeNode parent = null;
        TreeNode cur = this.Root;

        while (cur != null) {
            if (cur.val < value) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > value) {
                parent = cur;
                cur = cur.left;
            } else {
                //找到删除节点
                removeNode(parent, cur);
                System.out.println("已删除该节点");
                return;
            }
        }

        System.out.println("没找到删除节点");
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (cur == this.Root) {
                this.Root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == this.Root) {
                this.Root = cur.left;
            } else if (parent.left == cur) {
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


    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
