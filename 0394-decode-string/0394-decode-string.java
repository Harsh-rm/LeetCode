class Solution {
    int i;
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while (i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
                i++;
            }
            else if (c == '[') {
                i++;
                // Push the currStr and the currNum in to the recursive stack
                String decoded = decodeString(s);
                
                // Pop the currStr and append it to the decoded string and then append the resultant String to itself currNum times
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < currNum; j++) {
                    newStr.append(decoded);
                }
                currStr.append(newStr);
                currNum = 0;
            }
            else if (c == ']') {
                i++;
                return currStr.toString();
            }
            else {
                currStr.append(c);
                i++;
            }
        }

       return currStr.toString();
    }
}