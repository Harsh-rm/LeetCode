class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int max1 = 0;
        int slow = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i + 1);
            max1 = Math.max(max1, i - slow + 1);
        }
        
        return max1;
    }
}