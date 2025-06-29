class Solution {

    private Map<String, Integer> countMap = new HashMap<>();
    private Map<Character, Integer> freqMap = new HashMap<>();

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() < minSize) return 0;

        int l = 0, r = minSize - 1;

        // init first window
        for (int i = l; i <= r; i++) {
            addCharToMap(s.charAt(i));
        }

        String firstWindow = s.substring(l, r + 1);
        if (freqMap.size() <= maxLetters) {
            countMap.put(firstWindow, countMap.getOrDefault(firstWindow, 0) + 1);
        }

        // sliding window
        while (r + 1 < s.length()) {
            r++;
            addCharToMap(s.charAt(r));

            char c_l = s.charAt(l);
            if (decrementCharInMap(c_l) == 0) {
                freqMap.remove(c_l);
            }
            l++;

            String str = s.substring(l, r + 1); // window of minSize
            if (freqMap.size() <= maxLetters) {
                countMap.put(str, countMap.getOrDefault(str, 0) + 1);
            }
        }

        return countMap.isEmpty() ? 0 : Collections.max(countMap.values());
    }

    private void addCharToMap(Character c) {
        freqMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
    }

    private int decrementCharInMap(Character c) {
        freqMap.compute(c, (k, v) -> v == null ? 0 : v - 1);
        return freqMap.getOrDefault(c, 0);
    }
}
