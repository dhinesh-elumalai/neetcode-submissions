class Solution {

    /**
    * Iterate through your HashSet. 
    * For each number num, check if num - 1 is in the set.
    * If it's NOT there, you've found the start of a potential sequence. 
    * Only then, use a while loop to see how many consecutive numbers follow (num + 1, num + 2, etc.).
    */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> map = new HashSet<>();
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }

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
