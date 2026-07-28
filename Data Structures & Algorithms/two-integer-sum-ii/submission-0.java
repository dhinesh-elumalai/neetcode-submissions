class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1;
        // int[] result = new int[2];
        int left =0;
        while(left<right){
            int temp = numbers[left]+ numbers[right];
            if(target == temp){
                return new int[]{left+1, right+1};
            }else if(target>temp){
                left++;
            }else{
                right--;
            }
        }
        return new int[2];
    }
}
