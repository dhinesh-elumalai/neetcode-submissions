class Solution {
    public boolean isPalindrome(String s) {
        //Simpler Version that utilizes java's classes. 
        // We can also use two pointers to make it even more simpler..
        
        // 1. Build a cleaned string containing only lowercase letters/digits
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        // 2. Compare the cleaned string with its reverse
        String filtered = sb.toString();
        String reversed = sb.reverse().toString();

        return filtered.equals(reversed);
    }
}
