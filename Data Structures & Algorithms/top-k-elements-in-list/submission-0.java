// import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();


        // Time Complexity => O(n)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // Time Complexity => O(k*n)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int count = 0;
            Integer freqEle = nums[0];
            Set<Integer> keys = map.keySet();
            for (Integer key : keys) {
                if (count < map.get(key)) {
                    count = map.get(key);
                    freqEle = key;
                }
            }
            result[i]= freqEle;
            map.remove(freqEle);
        }

        return result;
    }
}
