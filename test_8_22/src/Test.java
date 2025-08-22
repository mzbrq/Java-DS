public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //复杂链表的复制
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);

            cur = cur.next;

        }

        return map.get(head);
    }

    //杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();

        List<Integer> tmp = new LinkedList<>();
        tmp.add(1);
        ret.add(tmp);



        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(1);

            for (int j = 1; j < i-1; j++) {
                List<Integer> tmp1 = ret.getLast();
                int result = tmp1.get(j-1)+tmp1.get(j);
                list.add(result);
            }

            list.add(1);
            ret.add(list);
        }

        return ret;
    }
}
