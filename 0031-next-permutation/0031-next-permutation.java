class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int n = nums.length;
        int index = -1;

        for (int i = (n - 2); i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                swapGreaterThanOnce(nums, i);
                index = i;
                break;
            }
        }

        manualSort(nums, index+1);
    
    }

    private void swapGreaterThanOnce(int[] nums, int k) {
        for (int i = (nums.length - 1); i >= 0; i--) {
            if(nums[k] < nums[i]) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }

    // Custom insertion sort method
    public static void manualSort(int[] arr, int startIndex) {
        for (int i = startIndex; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            // Move elements that are greater than current to the right
            while (j >= startIndex && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert current element in the correct position
            arr[j + 1] = current;
        }
    }
}