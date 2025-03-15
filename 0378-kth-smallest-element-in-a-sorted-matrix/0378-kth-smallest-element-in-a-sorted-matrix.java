class Solution {

    class HeapNode {
        private int value;
        private int row;
        private int col;

        public HeapNode(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public int getValue() {
            return this.value;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    class customComparator implements Comparator<HeapNode> {
        public int compare(HeapNode a, HeapNode b) {
            return a.value - b.value;
        }
    }

    private PriorityQueue<HeapNode> minHeap;
    private int length;

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;

        this.length = matrix.length;

        if (k == 0) return matrix[0][0];
        if (k == Math.pow(length, 2)) return matrix[length - 1][length - 1];

        this.minHeap = 
            new PriorityQueue<HeapNode>(
                Math.min(length, k), new customComparator());

        IntStream.range(0, Math.min(length, k)).forEach(i -> {
            HeapNode currElement = new HeapNode(matrix[i][0], i, 0);

            minHeap.offer(currElement);
        });

        HeapNode currElement = minHeap.peek();
        for (int i = 0; i < k; i++) {
            currElement = minHeap.poll();
            int currRow = currElement.getRow();
            int nextCol = currElement.getCol() + 1;

            if (nextCol < length) {
                minHeap.offer(new HeapNode(matrix[currRow][nextCol], currRow, nextCol));
            }
        }

        return currElement.value;
    }
}