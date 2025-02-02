class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int num = 0;

        //strStack.push(currStr);

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }
            else if (ch == '[') {
                strStack.push(currStr);
                numStack.push(num);
                num = 0;
                //currStr.setLength(0); //This modifies the reference of the currStr in the stack and hence does not work
                currStr = new StringBuilder();
            }
            else if (ch == ']') {
                int times = numStack.pop();
            /*  
                //This Method is more efficient     
                StringBuilder newStr = new StringBuilder();
                for (int count = 1; count < times; count++) {                    
                    newStr.append(currStr);
                }
                currStr = strStack.pop().append(newStr);
            */
                currStr.append(currStr.toString().repeat(times - 1)); //For Practice
                StringBuilder str = strStack.pop();
                currStr.insert(0, str);
            }
            else {
                currStr.append(ch);
            }
        }

        return currStr.toString();
    }
}