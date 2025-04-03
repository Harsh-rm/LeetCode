class Solution {

    private PriorityQueue<Integer> pq;

    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;

        pq = new PriorityQueue<>(n, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(b, a);
            }
        });

        IntStream.range(0, n).forEach(i -> {
            pq.offer(nums[i]);
        });

        IntStream.range(0, k - 1).forEach(i -> {
            pq.remove();
        });

        return pq.peek();
    }
}