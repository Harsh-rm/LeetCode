class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> charOccMap = new HashMap<>();
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            charOccMap.put(c, charOccMap.getOrDefault(c, 0) + 1);
        }

        boolean flag = true;

        for (char key: charOccMap.keySet()) {
            if (charOccMap.get(key) % 2 == 0) {
                longest += charOccMap.get(key);
            } else if (charOccMap.get(key) > 2) {
                if (flag) {
                    longest += charOccMap.get(key);
                    flag = false;
                } else {
                    longest += charOccMap.get(key) - 1;                    
                }
            } else {
                if (flag) {
                    longest++;
                    flag = false;
                }
            }
        }

        return longest;
    }
}