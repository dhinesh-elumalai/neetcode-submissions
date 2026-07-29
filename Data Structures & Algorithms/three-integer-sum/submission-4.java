class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2] 
        // Commented section if we dont have the feasibility of List.
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2;i++){
            // if (seen.contains(nums[i])) continue;
            int target = 0-nums[i];
            int left = i+1;
            int right = nums.length-1;
            System.out.println("Checking for target : "+ target);
            while(left<right){
                int curr = nums[left]+nums[right];
                if(target==curr){
                    List<Integer> numbers = List.of(nums[i], nums[left], nums[right]);
                    if(!result.contains(numbers)){
                        result.add(numbers);
                    }
                    // while (left < right && nums[left] == nums[left + 1]) left++;
                    // while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                    left++;
                } else if (target>curr){
                    left++;
                } else{
                    right--;
                }
            }
            seen.add(nums[i]);

        }
        return result;
    }
}
