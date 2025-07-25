public class BinarySearchTree {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode root;

    //插入
    public boolean insert(int value) {
        TreeNode newNode = new TreeNode(value);

        //当树没有节点时
        if (this.root == null) {
            this.root = newNode;
            return true;
        }

        TreeNode parent = null;
        TreeNode cur = this.root;

        while (cur != null) {
            if (cur.val < value) {
                parent = cur;
                cur = cur.right;

            } else if (cur.val > value) {
                parent = cur;
                cur = cur.left;
            } else {
                //二叉搜索树不能有相同节点
                return false;
            }
        }

        if (parent.val < value) {
            parent.right = newNode;
        }

        if (parent.val > value) {
            parent.left = newNode;
        }

        return true;
    }

    //搜索
    public boolean search(int val) {
        TreeNode cur = this.root;

        while (cur != null) {
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                return true;
            }
        }

        return false;
    }

    //中序遍历
    public void inOderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOderTraversal(root.left);

        System.out.print(root.val + " ");

        inOderTraversal(root.right);
    }


    //删除
    public void remove(int val) {
        TreeNode parent = null;
        TreeNode cur = this.root;

        //找到待删除节点位置
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                //找到删除节点，进行删除
                removeNode(parent, cur);
                return;
            }
        }
    }

    public void removeNode(TreeNode parent, TreeNode cur) {
        //情况一：删除节点左边为空
        if (cur.left == null) {
            if (cur == this.root) { //1. 删除节点为根节点
                this.root = cur.right;
            } else if (cur == parent.left) {//2. 删除节点在双亲节点左边
                parent.left = cur.right;
            } else { //3. 删除节点正在双亲节点右边
                parent.right = cur.right;
            }
        } else if (cur.right == null) { //情况二：删除节点右边为空
            if (cur == this.root) { //1. 删除节点为根节点
                cur = cur.left;
            } else if (cur == parent.left) {//2. 删除节点在双亲节点左边
                parent.left = cur.left;
            } else { //3. 删除节点正在双亲节点右边
                parent.right = cur.left;
            }
        } else { //情况三：删除节点两边都有节点
            TreeNode targetParent = cur;
            TreeNode target = cur.right;

            //找到 删除节点 右树最小节点 或 左树最大节点
            while (target.left != null) {
                targetParent = target.left;
                target = target.left;
            }

            //找到右数最小节点 把 删除节点数据覆盖
            cur.val = target.val;

            //删除右数最小节点
            if (target == targetParent.left) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }


}
