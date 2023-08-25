class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        int max = Integer.MIN_VALUE;
        int n = height.length;

        // for(int i = 0; i < n; i++) {
        //     for(int j = i + 1; j < n; j++) {
        //         max = Integer.max(max, Integer.min(height[i], height[j]) * (j - i));
        //     }
        // }

        int left = 0;
        int right = n - 1;

        while(left < right) {
            
            max = Integer.max(max, Integer.min(height[left], height[right]) * (right - left));

            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}