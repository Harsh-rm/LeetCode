class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == k) return;

        int n = nums.length;
        
        if (k > n) k = k % n;

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        
        while (start < end) {                        
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] numsArray, int left, int right) {
        numsArray[left] = numsArray[left] + numsArray[right];
        numsArray[right] = numsArray[left] - numsArray[right];
        numsArray[left] = numsArray[left] - numsArray[right];
    }
}