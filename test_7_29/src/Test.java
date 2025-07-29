import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }


    //宝石与石头
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;

        for (int j = 0; j < stones.length(); j++) {
            if (set.contains(stones.charAt(j))) {
                count++;
            }
        }


        return count;
    }

    //随机链表的复制
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            map.put(cur, new Node(cur.val));

            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);

            cur = cur.next;

        }

        return map.get(head);
    }


    //只出现一次的数字
    public int singleNumber(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }

        return -1;
    }
}
