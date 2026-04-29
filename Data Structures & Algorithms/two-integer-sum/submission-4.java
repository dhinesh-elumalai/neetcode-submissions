class Solution {
    public int[] twoSum(int[] nums, int target) {

        //This approach expects the array to be sorted. 
       /* int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                break;
            }
        }
        return new int[] {left, right};*/

        //This approach doesn't require sorting and works with negative numbers too.
        Map<Integer, Integer> keyMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int requiredValue = target - nums[i];
            if(!keyMap.containsKey(requiredValue)){
                keyMap.put(nums[i], i);
            }else{
                return new int[]{keyMap.get(requiredValue), i};
            }
        }
        return new int[2];
    }
}
