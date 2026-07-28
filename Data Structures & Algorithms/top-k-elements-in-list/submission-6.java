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
        /* int[] result = new int[k];
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

        return result; */

        // Method 2: Using O(N) complexity 
        // The following logic would not work when there is more than 1 similar frequencies..
        
        /* 
        int[] frequency = new int[nums.length+1];
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            frequency[map.get(key)] = key;
        }
        int j=0;
        int[] result = new int[k];
        for(int i=frequency.length-1; i>=0 && j<k ; i--){
            if(frequency[i]!=0){
                result[j]= frequency[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(result));
        return result; */

        //Method 3: O(N) using buckets to store data. 
        int[] result = new int[k];
        List<Integer>[] bucket = new List[nums.length+1];

        for(Integer key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int index =0;
        for(int i=bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int j=0; j<bucket[i].size();j++){
                    result[index]= bucket[i].get(j);
                    index++;
                    if(index==k) break;
                }
            }
        }

        return result;

    }
}
