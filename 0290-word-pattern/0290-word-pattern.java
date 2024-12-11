/*
    Leetcode problem 290: Word Pattern
    T.C: O(n) - length of the pattern String
    S.C: O(n) - O(n + n) = O(2n) (HashMap and HashSet of size n)

    Solved using a HashMap and a HashSet similar to Isomorphic strings
    Paired each character in the pattern string to the split(" ") string s in the HashMap
    and added the mapped string s to the HashSet. Comments added for checks in solution.
*/

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
            //Check if the Map contains the key for char c
            if (!charToStringMap.containsKey(c)) {
                charToStringMap.put(c, str);
                //Insert the char key and string value
                if (!mappedStringSet.contains(str)) { 
                    mappedStringSet.add(str);
                } else { //If the string was previously mapped return false
                    return false;
                }
            } else {
                //If the we are checking a key that already exist in map then 
                if (!charToStringMap.get(c).equals(str)) { // it should match the current string value
                    return false;
                }
            }
        }

        return true;
    }
}