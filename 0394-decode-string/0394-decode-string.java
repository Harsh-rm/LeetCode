class Solution {
    private String result;

    public String decodeString(String s) {
        result = "";
        
        if (s == null || s.length() == 0) return result;

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder str = new StringBuilder();
        int currNum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                numStack.push(currNum);
                strStack.push(str);
                currNum = 0;
                str = new StringBuilder();
            }
            else if (s.charAt(i) == ']') {
                int times = numStack.pop();
                str.append(str.toString().repeat(times - 1));
                str.insert(0, strStack.pop());                
            }
            else if (Character.isDigit(s.charAt(i))) {
                currNum = 10 * currNum + Character.getNumericValue(s.charAt(i));
            }
            else {
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}