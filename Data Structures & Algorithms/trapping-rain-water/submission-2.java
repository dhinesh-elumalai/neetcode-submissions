class Solution {
    public int trap(int[] height) {
        // Initial solution. Not working for all cases.
        /* int left = 0;
        int right = height[height.length - 1];
        int maxArea = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int currArea = 0;
            while (i < height.length && max > height[i]) {
                currArea += max - height[i];
                i++;
            }

            if (i == height.length)
                break;
            maxArea += currArea;
            max = height[i];
        }
        return maxArea; */
        /**
        * We can store the prefix maximum in an array by iterating from left to right 
        * and the suffix maximum in another array by iterating from right to left. 
        * For example, in [1, 5, 2, 3, 4], for the element 3, the prefix maximum is 5, 
        * and the suffix maximum is 4. 
        * Once these arrays are built, we can iterate through the array with index i and 
        * calculate the total water trapped at each position using the formula: min(prefix[i], suffix[i]) - height[i].
        */
        int length = height.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int maxArea = 0;
        prefix[0] = 0;
        suffix[length - 1] = 0;

        // Calculate prefix
        for (int i = 1; i < length; i++) {
            if (height[i - 1] > prefix[i - 1]) {
                prefix[i] = height[i - 1];
            } else {
                prefix[i] = prefix[i - 1];
            }
        }
        System.out.println("Prefix : " + Arrays.toString(suffix));
        // Calculate Suffix
        for (int i = length - 2; i >= 0; i--) {
            if (height[i + 1] > suffix[i + 1]) {
                suffix[i] = height[i + 1];
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        System.out.println("Suffix : " +Arrays.toString(suffix));

        for(int i=0; i< length; i++){
            int currArea = Math.min(prefix[i], suffix[i]) - height[i];
            if(currArea>0) maxArea +=currArea;
        }
        return maxArea;
    }
}
