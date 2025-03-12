 class Solution {
    private double result;
    private int n1, n2, total;
    private int target;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        n1 = nums1.length;
        n2 = nums2.length;
        total = n1 + n2;
        target = (total + 1) / 2;
        
        int left = 0, right = n1;

        while (true) {
            int take1 = left + (right - left) / 2;
            int take2 = target - take1;

            int l1 = (take1 == 0) ? Integer.MIN_VALUE : nums1[take1 - 1];
            int r1 = (take1 == n1) ? Integer.MAX_VALUE : nums1[take1];
            int l2 = (take2 == 0) ? Integer.MIN_VALUE : nums2[take2 - 1];
            int r2 = (take2 == n2) ? Integer.MAX_VALUE : nums2[take2];

            if (l1 > r2) {
                right = take1 - 1;                
                continue;
            }

            if (r1 < l2) {
                left = take1 + 1;
                continue;
            }

            result = Math.max(l1, l2);
            if (total % 2 == 1) {
                return result;
            } else {
                return (result + Math.min(r1, r2)) / 2.0;
            }
        }
    }
}