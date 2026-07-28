class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> map = new HashSet<>();
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }

        // for(int i=0; i<map.size(); i++){
        //     int target = nums[i]+1;
        //     if(map.contains(target)){
        //         count++;
        //     }
        // }
        for (Integer curr : map) {
            int currentStreak = 1;
            if (map.contains(curr - 1)) {
                currentStreak++;
                while(map.contains(curr+1)){
                    currentStreak++;
                    curr++;
                }
                count = Math.max(count, currentStreak);
            }
        }
        return count;
    }
}
