import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

    //随机链表的复制
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        //遍历链表 创建节点 存放在 map中 对应 value
        Node cur = head;

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //根据 key 中节点 链接 value 中的节点

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    //前高频 k 个单词
    public List<String> topKFrequent(String[] words, int k) {
        //遍历数组 统计单词出现次数
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                int count = map.get(s)+1;
                map.put(s, count);
            }
        }

        //建立小根堆 找到出现前 k 个高频单词
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>
                (new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                        return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
                    }
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                //判断 次数是否大于堆顶元素
                Integer topValue = pq.peek().getValue();

                if (topValue == entry.getValue()) {
                    //次数相等，按照单词比较
                    String topKey = pq.peek().getKey();

                    if (entry.getKey().compareTo(topKey) < 0) {
                        pq.poll();
                        pq.offer(entry);
                    }
                } else {
                    if (topValue.compareTo(entry.getValue()) < 0) {
                        pq.poll();
                        pq.offer(entry);
                    }
                }
            }
        }

        //把前 k 个高频单词储存到 list 中
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> top = pq.poll();
            ret.add(top.getKey());
        }

        //逆序 list 返回

        Collections.reverse(ret);

        return ret;
    }


    //存在重复的元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }

    //存在重复的元素二
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int index = map.get(nums[i]);

                if (Math.abs(index-i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }

        return false;

    }
}
