class Solution {
    public boolean isPalindrome(String s) {
        //Using Two POinters... Easiest and fastest...
        char[] curr = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(!Character.isLetterOrDigit(curr[left])){
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(curr[right])){
                right--;
                continue;
            }

            if(Character.toLowerCase(curr[left])!=Character.toLowerCase(curr[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
