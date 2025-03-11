class Solution {
    private int[] mergedArray;
    private double result;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        result = 0;

        if (nums1.length == 0 && nums2.length == 0) return result;

        int m = nums1.length;
        int n = nums2.length;
        mergedArray = new int[m + n];

        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                mergedArray[p3] = nums1[p1];
                p1++;
            } else {
                mergedArray[p3] = nums2[p2];
                p2++;
            }
            p3++;
        }

        while (p2 < n) {
            mergedArray[p3] = nums2[p2];
            p2++; p3++;
        }

        while (p1 < m) {
            mergedArray[p3] = nums1[p1];
            p1++; p3++;
        }

        if ((m + n) % 2 == 0) {
            int temp = (m + n) / 2;            
            result = (double) (mergedArray[temp - 1] + mergedArray[temp]) / 2;
        } else {
            int temp = (m + n) / 2;
            result = mergedArray[temp];
        }

        return result;                
    }
}