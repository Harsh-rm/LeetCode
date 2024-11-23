class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[] {};

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> MonotonicMinStack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while(!MonotonicMinStack.isEmpty() && temperatures[i] > temperatures[MonotonicMinStack.peek()]) {
                int index = MonotonicMinStack.pop();
                result[index] = i - index;
            }

            MonotonicMinStack.push(i);
        }

        return result;
    }
}