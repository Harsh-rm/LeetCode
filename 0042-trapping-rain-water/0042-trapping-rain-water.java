class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int lw = height[l], rw = height[r];
        int result = 0;

        while(l <= r) {
            if (lw <= rw) {
                if (lw > height[l]) {
                    result += lw - height[l];
                } else {
                    lw = height[l];                    
                }
                l++;
            } else {
                if (rw > height[r]) {
                    result += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }

        return result;
    }
}