class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<Double, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
          String str = strs[i];
          double primeProduct = primeProduct(str);
          if(!map.containsKey(primeProduct)) {
            map.put(primeProduct, new ArrayList<>());
          }
          map.get(primeProduct).add(str);
        }

        return new ArrayList<>(map.values());
        //Sorting the String
        // HashMap<String, List<String>> map = new HashMap<>();

        // for(int i = 0; i < strs.length; i++){
        //   String str = strs[i];
        //   char[] charArr = str.toCharArray();
        //   Arrays.sort(charArr);
        //   String sortedString = String.valueOf(charArr);
        //   if(!map.containsKey(sortedString)) {
        //     map.put(sortedString, new ArrayList<>());
        //   }
        //   map.get(sortedString).add(str);
        // }
        // return new ArrayList<>(map.values());
    }

    private double primeProduct(String s) {
      int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

      double result = 1;
      char[] charArr = s.toCharArray();

      for(int i = 0; i < s.length(); i++) {
        // char c = charArr[i];
        char c = s.charAt(i);
        result = result * primes[c - 'a'];
      }

      return result;
    }
}