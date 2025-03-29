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
                    swap(nums, 0, i);

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
            swap(nums, index, largestElementIndex);

            heapify(nums, largestElementIndex, heapSize);
        }
    }

    private void swap(int[] nums, int first, int last) {
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;

        return;
    }
}