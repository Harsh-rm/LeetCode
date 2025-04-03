class Solution {

    private PriorityQueue<Integer> pq;

    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;

        pq = new PriorityQueue<>();

        IntStream.range(0, n).forEach(i -> {
            pq.offer(nums[i]);
        });

        for(int i = 0; i < n - k; i++) {
            pq.remove();
        }

        return pq.peek();
    }
}