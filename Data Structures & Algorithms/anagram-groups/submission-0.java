class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Bruteforce
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> subList = new ArrayList<>();
            if(strs[i]==null) continue;
            subList.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                if(isAnagram(strs[i], strs[j])){
                    subList.add(strs[j]);
                    strs[j] =null;
                }
            }
            result.add(subList);
        }
        return result;
    }

    public static boolean isAnagram(String s1, String s2){
        if(s1==null || s2==null) return false;
        if(s1.length()!=s2.length()) return false;
        char[] char1Array = s1.toCharArray();
        char[] char2Array = s2.toCharArray();
        int[] charCountArray = new int[26];
        for(int i=0; i< s1.length(); i++){
            charCountArray[char1Array[i]-'a']++;
            charCountArray[char2Array[i]-'a']--;
        }
        for(int i=0;i<charCountArray.length; i++){
            if(charCountArray[i]!=0) return false;
        }
        return true;
    }
}
