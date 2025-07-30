public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }




    //前k个数字

    public int[] smallestK(int[] arr, int k) {
        //==== 方法一 ====
        // if (arr == null || k <= 0) {
        //     return new int[0];
        // }

        // PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length);

        // //把数组元素插入到堆中
        // for (int i = 0; i < arr.length; i++) {
        //     pq.offer(arr[i]);
        // }

        // //拿出前 k 个元素放到数组中，返回
        // int[] ret = new int[k];

        // for (int z = 0; z < k; z++) {
        //     ret[z] = pq.poll();
        // }

        // return ret;


        //===== 方法二 ====
        if (arr == null || k <= 0) {
            return new int[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new IntCmp());

        //使用数组前 k 个建大堆
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        //剩余的 n-k个与堆顶元素比较
        for (int j = k; j < arr.length; j++) {
            //数据比堆顶元素小就 出堆顶，入元素
            if (pq.peek() > arr[j]) {
                //出堆顶，入元素
                pq.poll();
                pq.offer(arr[j]);
            }
        }

        //最后，把堆中元素存到数组中，返回
        int[] ret = new int[k];

        for (int z = 0; z < k; z++) {
            ret[z] = pq.poll();
        }

        return ret;

    }


    //字符串中 第一个唯一字符
    public int firstUniqChar(String s) {
        int[] countArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (countArr[s.charAt(j)-'a'] == 1) {
                return j;
            }
        }

        return -1;

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



}
