import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println("刷题");
    }

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
}
