public class Solution {
    public TreeNode head;
    public TreeNode prev;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        Convert(pRootOfTree.left);

        if (prev == null) {
            head = pRootOfTree;
            prev = pRootOfTree;
        } else {
            prev.right = pRootOfTree;
            pRootOfTree.left = prev;
            prev = pRootOfTree;
        }

        Convert(pRootOfTree.right);

        return head;
    }
}
