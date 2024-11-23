class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[] {};

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> MonotonicMaxStack = new Stack<>();
        
        MonotonicMaxStack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {

            while(!MonotonicMaxStack.isEmpty() && temperatures[i] >= temperatures[MonotonicMaxStack.peek()]) {
                MonotonicMaxStack.pop();
            }

            if (!MonotonicMaxStack.isEmpty()) {
                int index = MonotonicMaxStack.peek() - i;
                result[i] = index;
            }

            MonotonicMaxStack.push(i);
        }

        return result;
    }
}