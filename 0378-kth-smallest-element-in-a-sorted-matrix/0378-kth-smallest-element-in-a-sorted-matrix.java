class Solution {
    
    public class HeapNode {
        private int value;
        private int row;
        private int col;
        
        public HeapNode(int val, int row, int col) {
            this.value = val;
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
    
    public class CustomComparator implements Comparator<HeapNode> {
        public int compare(HeapNode a, HeapNode b) {
            return Integer.compare(a.value, b.value);
        }
    }
    
    private PriorityQueue<HeapNode> minHeap;
    private int length;
        
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        
        this.length = matrix.length;
        
        this.minHeap = new PriorityQueue<HeapNode>(
            Math.min(length, k), new CustomComparator());
        
        if (k == 0) return matrix[0][0];
        if (k == Math.pow(length, 2)) return matrix[length - 1][length - 1];
        
        IntStream.range(0, Math.min(length, k)).forEach(i -> {
            HeapNode ele = new HeapNode(matrix[i][0], i, 0);
            
            minHeap.offer(ele); 
        });
        
        HeapNode currElement = minHeap.peek();
        while(k-- > 0) {
            currElement = minHeap.poll();
            int currRow = currElement.getRow();
            int nextCol = currElement.getCol() + 1;
            
            if (nextCol < length) {
                minHeap.offer(new HeapNode(matrix[currRow][nextCol], currRow, nextCol));
            }
        }
        
        return currElement.getValue();
    }
}