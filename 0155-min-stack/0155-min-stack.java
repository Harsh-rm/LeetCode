class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int mini;

    public MinStack() {
        mini = Integer.MAX_VALUE;
        s = new Stack<>();
        minStack = new Stack<>();
        minStack.push(mini);
    }
    
    public void push(int val) {
        mini = Math.min(mini, val);
        s.push(val);
        minStack.push(mini);
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        mini = minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */