class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Not working when there is 0 in the array. Also use of division is not recommended for this problem...
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0]=1;
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        System.out.println("Prefix " + Arrays.toString(prefix));
        suffix[nums.length-1]=1;
        for(int i=nums.length-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        System.out.println("Suffix " + Arrays.toString(suffix));
        for(int i=0;i<nums.length;i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
