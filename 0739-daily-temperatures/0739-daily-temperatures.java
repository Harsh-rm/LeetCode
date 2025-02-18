class Solution {
    private int[] result;
    
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];

        Stack<Integer> lowerTemp = new Stack<>();
        int n = temperatures.length;
        result = new int[n];
        
        lowerTemp.push(0);

        for (int i = 0; i < n; i++) {
            while (!lowerTemp.isEmpty() && temperatures[i] > temperatures[lowerTemp.peek()]) {
                int idx = lowerTemp.pop();
                result[idx] = i - idx;
            }
            lowerTemp.push(i);
        }

        return result;
    }
}