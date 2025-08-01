class Solution {

    private int n, result;

    public int calculate(String s) {
        this.result = Integer.MIN_VALUE;
        if (s == null || s.length() == 0) return result;

        s = s.trim();
        this.n = s.length();
        int calc = 0;
        int num = 0;
        int tail = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || (i == n - 1)) {
                if (sign == '+' || sign == '-') {
                    calc = (sign == '+') ? calc + num : calc - num;
                    tail = (sign == '-') ? -num : num;
                }
                else if (sign == '*' || sign == '/') {
                    calc = (sign == '*') ? calc - tail + tail * num : calc - tail + tail / num;
                    tail = (sign == '*') ? tail * num : tail / num;
                }
                num = 0;
                sign = ch;
            }
        }

        result = calc;

        return result;
    }
}