class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null|| t == null) return true;
        if(s.length() != t.length()) return false;

        char[] sArray = new char[127];
        char[] tArray = new char[127];
        
        for(int i = 0; i < s.length(); i++) {
          char sChar = s.charAt(i);
          char tChar = t.charAt(i);

          if(sArray[sChar - ' '] != '\u0000') {
            if(sArray[sChar  - ' ']  != tChar) {
              return false;
            }
          }
          else {
             sArray[sChar - ' '] = tChar;
          }

          if(tArray[tChar - ' '] != '\u0000') {
            if(tArray[tChar - ' '] != sChar) {
              return false;
            }
          }
          else {
              tArray[tChar - ' '] = sChar;
          }
        }
        // HashMap<Character, Character> smap = new HashMap<>();
        // // HashMap<Character, Character> tmap = new HashMap<>();
        // HashSet<Character> tset = new HashSet<>();

        // for(int i = 0; i < s.length(); i++){
        //   char schar = s.charAt(i);
        //   char tchar = t.charAt(i);
          
        //   if(smap.containsKey(schar)){
        //     if(tchar != smap.get(schar)){
        //       return false;
        //     }
        //   }
        //   else{
        //     if(tset.contains(tchar)){
        //       return false;
        //     }
        //     smap.put(schar, tchar);
        //     tset.add(tchar);
        //   }
        // }
        return true;
    }
}