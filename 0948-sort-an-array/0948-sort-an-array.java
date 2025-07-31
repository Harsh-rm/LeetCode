class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);

        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);

            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1, k = left;

        while (i < mid + 1 && j <= right) {
            if (temp[i] < temp[j]) {
                nums[k++] = temp[i++];                
            }
            else {
                nums[k++] = temp[j++];
            }
        }

        while (i < mid + 1) {
            nums[k++] = temp[i++];
        }
    }
}