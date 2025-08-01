class Solution {

    private int result, n, currNum;
    private Stack<Integer> calcStack;
    private char operator;

    public int calculate(String s) {
        this.result = 0;

        if (s == null || s.length() == 0) return result;

        s = s.trim();
        this.n = s.length();
        this.calcStack = new Stack<>();
        this.currNum = 0;
        this.operator = '+';
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || (i == n - 1)) {
                if (operator == '*' || operator == '/') {
                    int temp = calcStack.pop();
                    temp = (operator == '*') ? temp * currNum : temp / currNum;
                    calcStack.push(temp);
                }
                else if (operator == '+' || operator == '-') {
                    int temp = (operator == '-') ? -currNum : currNum;
                    calcStack.push(temp);
                }
                
                currNum = 0;
                operator = ch;
            }
        }

        while (!calcStack.isEmpty()) {
            result += calcStack.pop();
        }

        return result;
    }
}