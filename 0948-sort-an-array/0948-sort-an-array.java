class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }

        return;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] tempArr = new int[nums.length];

        for (int i = 0; i < n1; i++) {
            tempArr[start1 + i] = nums[start1 + i];
        }
        for (int j = 0; j < n2; j++) {
            tempArr[start2 + j] = nums[start2 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] < tempArr[start2 + j]) {
                nums[k] = tempArr[start1 + i];
                i++;
            }
            else {
                nums[k] = tempArr[start2 + j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            nums[k] = tempArr[start1 + i];
            i++; k++;
        }

        while (j < n2) {
            nums[k] = tempArr[start2 + j];
            j++; k++;
        }
    }
}