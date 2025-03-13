class Solution {
    private PriorityQueue<int[]> leastEndTimes;

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, 
            new Comparator<int[]>() {
                public int compare(final int[] a, final int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });

        leastEndTimes = 
            new PriorityQueue<int[]>(
                intervals.length,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return Integer.compare(a[1], b[1]);
                    }
                });
        
        IntStream.range(0, intervals.length).forEach(i -> {
            if (!leastEndTimes.isEmpty()) {
                if (leastEndTimes.peek()[1] <= intervals[i][0]) {
                    leastEndTimes.poll();
                }                
            }

            leastEndTimes.offer(intervals[i]);            
        });

        return leastEndTimes.size();
    }
}