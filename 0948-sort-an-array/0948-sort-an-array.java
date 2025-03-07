class Solution {
    private int arrayLength;
    private boolean flag;

    public int[] sortArray(int[] nums) {
        if (nums.length == 0) return nums;        

        try {
            this.arrayLength = nums.length;

            flag = heapSort(nums);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new int[0]; 
        }

        if (flag) System.out.println("sortArray(nums) ran successfully!");

        return nums;
    }

    private boolean heapSort(int[] nums) {
        int lastParent = arrayLength / 2 - 1;

        IntStream.iterate(lastParent, i -> i >= 0, i -> i - 1)
                .forEach(i -> {
                    heapify(nums, i, arrayLength);
                });

        IntStream.iterate(arrayLength - 1, i -> i > 0, i -> i - 1)
                .forEach(i -> {
                    int temp = nums[0];
                    nums[0] = nums[i];
                    nums[i] = temp;

                    heapify(nums, 0, i);
                });

        return true;
    }

    private void heapify(int[] nums, int index, int heapSize) {
        int largestElementIndex = index;

        int leftChild = 2 * largestElementIndex + 1;

        int rightChild = 2 * largestElementIndex + 2;

        if (leftChild < heapSize && nums[leftChild] > nums[largestElementIndex]) {
            largestElementIndex = leftChild;
        }

        if (rightChild < heapSize && nums[rightChild] > nums[largestElementIndex]) {
            largestElementIndex = rightChild;
        }

        if (largestElementIndex != index) {
            int temp = nums[largestElementIndex];
            nums[largestElementIndex] = nums[index];
            nums[index] = temp;

            heapify(nums, largestElementIndex, heapSize);
        }
    }
}