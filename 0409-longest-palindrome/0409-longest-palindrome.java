class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int longestResult = 0;
        HashSet<Character> setChecksPairs = new HashSet<>();        

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (setChecksPairs.contains(c)) {
                longestResult += 2;
                setChecksPairs.remove(c);
            } else {
                setChecksPairs.add(c);
            }
        }
        
        if (setChecksPairs.size() > 0) {
            longestResult += 1;
        }
        return longestResult;
    }
}