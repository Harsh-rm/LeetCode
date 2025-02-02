class Solution {
    int i;
    
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder currStr = new StringBuilder();
        int num = 0;

        while (i < s.length()) {
            Character ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
                i++;
            }
            else if (ch == '[') {
                i++;
                String decoded = decodeString(s);
                //Pop operation from the inner encoded part that has to be appened to the currStr after multiplying it
                currStr.append(decoded.repeat(num));
                num = 0;
            }
            else if (ch == ']') {
                i++;
                return currStr.toString();
            }
            else {
                currStr.append(ch);
                i++;
            }
        }

        return currStr.toString();
    }
}