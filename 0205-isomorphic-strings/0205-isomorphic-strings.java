class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() != t.length()) return false;

        HashMap<Character, Character> checkIso = new HashMap<>();
        HashSet<Character> charMapped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!checkIso.containsKey(sChar)){

                if (!charMapped.contains(tChar)) {
                    charMapped.add(tChar);
                    checkIso.put(sChar, tChar);
                } else {
                    return false;
                }

            } else {
                // Challenge lies in this condition - if the char is already mapped then we need to check if the mapping element is the same
                //As we are using Hashset based solution we need to check if current mapping element is in the hashset
                if (!charMapped.contains(tChar) || tChar != checkIso.get(sChar)) { 
                    return false;
                }

            }
        }

        return true;
    }
}