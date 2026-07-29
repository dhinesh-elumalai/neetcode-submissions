class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        // [1,7,2,5,4,7,3,6]
        // while(left<right){
        //     int distance = right-left;
        //     int height = Math.min(heights[left], heights[right]);
        //     int currArea = height * distance;
        //     if(currArea>maxArea){
        //         maxArea= currArea;
        //     }
        //     //right--;
        //     left++;
        // }
        //[1,7,2,5,12,3,500,500,7,8,4,7,3,6]
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = heights.length - 1;
            while (left < right) {
                int distance = right - left;
                int height = Math.min(heights[left], heights[right]);
                int currArea = height * distance;
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
                right--;
                // left++;
            }
        }
        return maxArea;
    }
}
