class Solution {

    private Stack<Integer> lessThanPrevious;
    private Integer n, maxWidth;

    public int maxWidthRamp(int[] nums) {
        this.maxWidth = 0;

        if (nums == null || nums.length == 0) return maxWidth;

        this.lessThanPrevious = new Stack<>();
        this.n = nums.length;

        IntStream.range(0, n).forEach(i -> {
            if (lessThanPrevious.isEmpty() || nums[i] < nums[lessThanPrevious.peek()]) {
                lessThanPrevious.push(i);
            }
        });

        for (int i = n - 1; i >= 0; i--) {
            while (!lessThanPrevious.isEmpty() && nums[i] >= nums[lessThanPrevious.peek()]) {
                maxWidth = Math.max(maxWidth, i - lessThanPrevious.peek());

                lessThanPrevious.pop();
            }
        }

        return maxWidth;
    }
}