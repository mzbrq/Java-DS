public class BinaryTree {
    public static class BTNode {
        private int value;
        BTNode left;
        BTNode right;

        BTNode (int data) {
            this.value = data;
        }


    }

    private BTNode Root; //根节点

    //创建一颗临时二叉树
    public BTNode CreateTree () {
        BTNode A = new BTNode(1);
        BTNode B = new BTNode(2);
        BTNode C = new BTNode(3);
        BTNode D = new BTNode(4);
        BTNode E = new BTNode(5);
        BTNode F = new BTNode(6);
        BTNode G = new BTNode(7);

        //链接
        this.Root = A;
        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = F;
        C.right = G;

        return A;

    }


}
