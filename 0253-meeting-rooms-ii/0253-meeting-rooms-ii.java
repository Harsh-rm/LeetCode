class Solution {

    public class HeapNode {
        private int start;
        private int end;
        private int freq;

        public HeapNode(int[] time, int freq) {
            this.start = time[0];
            this.end = time[1];
            this.freq = freq;
        }
    }

    public class CompareStartTimes implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }

    public class CompareEndTimes implements Comparator<HeapNode> {
        public int compare(HeapNode a, HeapNode b) {
            return Integer.compare(a.end, b.end);
        }
    }

    private int result = 0;

    public int minMeetingRooms(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0) return 0;

        PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>(intervals.length, new CompareEndTimes());

        Set<Integer> set = new HashSet<>();

        Arrays.sort(intervals, new CompareStartTimes());
        
        IntStream.range(0, intervals.length).forEach(i -> {

            HeapNode node = new HeapNode(intervals[i], (intervals[i][0] + intervals[i][1]));

            if (!pq.isEmpty()) {                

                if (intervals[i][0] >= pq.peek().end) {                    
                    set.remove(pq.poll().freq);
                }
            }

            pq.offer(node);
            set.add(node.freq);
            result = this.calculateMax(set);
        });

        return pq.size();
    }

    private int calculateMax(Set<Integer> set) {
        int sum = 0;
        for (int val : set) {
            sum += val;
        }

        return sum;
    }
}