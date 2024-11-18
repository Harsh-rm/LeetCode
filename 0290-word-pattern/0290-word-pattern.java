class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");

        if (pattern.length() != strArray.length) return false;

        HashMap<Character, String> charToStringMap = new HashMap<>();
        HashSet<String> stringMappedTochar = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            String str = strArray[i];
            char c = pattern.charAt(i);

            if (!charToStringMap.containsKey(c)) {
                charToStringMap.put(c, str);

                if(!stringMappedTochar.contains(str)) {
                    stringMappedTochar.add(str);
                } else {
                    return false;
                }
            } else {
                if (!str.equals(charToStringMap.get(c))) {
                    return false;
                }                
            }
        }

        return true;
    }

}