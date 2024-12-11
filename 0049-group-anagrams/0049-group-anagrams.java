    /*
        Leetcode problem 49: Group Anagrams
        T.C: O(nk*log(k)) :: S.C: O(n)

        Solved using a HashMap of sorted strings as key and List of strings that grouped 
        as anagrams as values. Finally return all the values as a new ArrayList.
    */

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();
            
            HashMap<String, List<String>> sortedStringMap = new HashMap<>();

            for(int i = 0; i < strs.length; i++) {
                String str = strs[i];
                
                //Sort the string in ascending order
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedString = String.valueOf(charArray);
                
                //Check if the sortedString is present in the HashMap
                if (!sortedStringMap.containsKey(sortedString)) {
                    sortedStringMap.put(sortedString, new ArrayList<>());
                }
                //Finally update the key in hashmap with the current string
                sortedStringMap.get(sortedString).add(str);
            }

            return new ArrayList<>(sortedStringMap.values());
        }
    }