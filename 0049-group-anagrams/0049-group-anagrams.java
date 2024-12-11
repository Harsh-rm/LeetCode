    /*
        Leetcode problem 49: Group Anagrams
        T.C: O(nk*log(k)) :: S.C: O(n)

        Solved using a HashMap of sorted strings as key and List of strings that grouped 
        as anagrams as values. Finally return all the values as a new ArrayList.
    */

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();
            
            HashMap<Double, List<String>> primeProductMap = new HashMap<>();

            for(int i = 0; i < strs.length; i++) {
                String str = strs[i];
                
                double primeProduct = primeProduct(str);
                
                //Check if the sortedString is present in the HashMap
                if (!primeProductMap.containsKey(primeProduct)) {
                    primeProductMap.put(primeProduct, new ArrayList<>());
                }
                //Finally update the key in hashmap with the current string
                primeProductMap.get(primeProduct).add(str);
            }

            return new ArrayList<>(primeProductMap.values());
        }

        private double primeProduct(String str) {
            int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
            double result = 1;

            //Find the product of all prime numbers associated with each char in str
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                result = result * primes[c - 'a'];
            }

            return result;
        }
    }