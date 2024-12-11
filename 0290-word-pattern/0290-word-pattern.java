class Solution {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) return false;

        String[] sArray = s.split(" ");

        if (pattern.length() != sArray.length) return false;

        HashMap<Character, String> charToStringMap = new HashMap<>();
        HashSet<String> mappedStringSet = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = sArray[i];

            if (!charToStringMap.containsKey(c)) {
                charToStringMap.put(c, str);

                if (!mappedStringSet.contains(str)) {
                    mappedStringSet.add(str);
                } else {
                    return false;
                }
            } else {
                if (!charToStringMap.get(c).equals(str)) {
                    return false;
                }
            }
        }

        return true;
    }
}