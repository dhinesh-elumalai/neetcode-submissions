class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String word : strs) {
            result.append(word.length()).append("#").append(word);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int hashIndex = str.indexOf("#", i);
            int wordLength = Integer.parseInt(str.substring(i, hashIndex));
            int wordStartIndex = hashIndex + 1;
            String word = str.substring(wordStartIndex, wordStartIndex + wordLength);
            result.add(word);
            i = wordStartIndex + wordLength;
        }
        return result;
    }
}
