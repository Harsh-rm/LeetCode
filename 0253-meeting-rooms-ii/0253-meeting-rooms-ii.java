class Solution {

    public class CompareStartTimes implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }

    public class CompareEndTimes implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, new CompareEndTimes());

        Arrays.sort(intervals, new CompareStartTimes());
        
        IntStream.range(0, intervals.length).forEach(i -> {
            if (!pq.isEmpty()) {
                int[] temp = pq.peek();
                if (intervals[i][0] >= temp[1]) {
                    pq.poll();
                }
            }

            pq.offer(intervals[i]);
        });

        return pq.size();
    }
}