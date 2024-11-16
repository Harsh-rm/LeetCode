class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");

        if (pattern.length() != strArray.length) return false;

        HashMap<Character, String> charToStringMap = new HashMap<>();
        HashMap<String, Character> stringToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String str = strArray[i];
            char c = pattern.charAt(i);

            if (charToStringMap.containsKey(c)) {
                if (!str.equals(charToStringMap.get(c))) {
                    return false;
                }
            } else {
                charToStringMap.put(c, str);
            }

            if (stringToCharMap.containsKey(str)) {
                if (c != stringToCharMap.get(str)) {
                    return false;
                }
            } else {
                stringToCharMap.put(str, c);
            }
        }

        return true;
    }
}