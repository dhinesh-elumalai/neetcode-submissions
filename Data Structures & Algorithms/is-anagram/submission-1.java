class Solution {
    public boolean isAnagram(String s, String t) {
        // Java sorting usage ; Complexity => O(log n)
       /* if(s.length()!=t.length()) return false;
        char[] firstArray = s.toCharArray();
        char[] secondArray = t.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        for(int i=0; i< firstArray.length;i++){
            if(firstArray[i]!=secondArray[i]) return false;
        }
        return true;
        */

        if(s.length() != t.length()) return false;
        int[] charCounts = new int[26];

        for(int i=0;i<s.length();i++){
            // Increment for string s
            charCounts[s.charAt(i)-'a']++;
            // Decrement for string t
            charCounts[t.charAt(i)-'a']--;
        }
        // Check if all counts are back to zero
        for(int count : charCounts){
            if(count!=0) return false;
        }
        return true;

    }
}
