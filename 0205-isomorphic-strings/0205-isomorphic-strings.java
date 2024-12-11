class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = new char[96]; //store sChar to tChar mapping
        char[] tArray = new char[96]; //store tChar to sChar mapping

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sArray[sChar - ' '] == '\u0000') {
                sArray[sChar - ' '] = tChar;
            } else {
                if (sArray[sChar - ' '] != tChar) {
                    return false;
                }
            }

            if (tArray[tChar - ' '] == '\u0000') {
                tArray[tChar - ' '] = sChar;
            } else {
                if (tArray[tChar - ' '] != sChar) {
                    return false;
                }
            }
        }

        return true;
    }
}