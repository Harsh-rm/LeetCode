class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;

        int left = 0, right = height.length - 1;
        int lh = 0, rh = 0;
        int result = 0;

        while (left <= right) {

            if (lh <= rh) {
                if (lh > height[left]) {
                    result += lh - height[left];
                } else {
                    lh = height[left];
                }
                left++;

            } else {
                if (rh > height[right]) {
                    result += rh - height[right];                    
                } else {
                    rh = height[right];
                }
                right--;
            }
        }

        return result;
    }
}