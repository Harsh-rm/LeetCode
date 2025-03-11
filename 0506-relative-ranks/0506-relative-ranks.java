class Solution {
    private String[] result;

    private enum Ranks {
        FIRST("Gold Medal"), SECOND("Silver Medal"), THIRD("Bronze Medal");

        private final String message;

        Ranks(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        this.result = new String[0];

        if (score == null || score.length == 0) return result;

        //Calculate the depandencies for smooth execution of the program
        int n = score.length;
        this.result = new String[n];

        //Use Heap Data Structure to solve the relative ranking problem
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        //Iterate over score array and add to the max heap
        IntStream.range(0, n).forEach(i -> {
            maxHeap.offer(new int[] {score[i], i});
        });

        int[] tempIdx = maxHeap.poll();
        result[tempIdx[1]] = Ranks.FIRST.getMessage();

        if (!maxHeap.isEmpty()) {
            tempIdx = maxHeap.poll();
            result[tempIdx[1]] = Ranks.SECOND.getMessage();
        }

        if (!maxHeap.isEmpty()) {
            tempIdx = maxHeap.poll();
            result[tempIdx[1]] = Ranks.THIRD.getMessage();
        }

        int rank = 4;
        while (!maxHeap.isEmpty()) {
            tempIdx = maxHeap.poll();

            result[tempIdx[1]] = Integer.toString(rank);

            rank++;
        }

        return result;
    }
}