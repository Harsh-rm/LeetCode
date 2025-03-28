class Solution {
    private String result;
    private HashMap<Character, Integer> tOccurrence;

    public String minWindow(String s, String t) {
        result = "";
        tOccurrence = new HashMap<>();

        if (s.length() == 0 || t.length() == 0) return result;

        if (t.length() > s.length()) return result;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            tOccurrence.put(c, tOccurrence.getOrDefault(c, 0) + 1);
        }
        
        int l = 0, r = 0, flag = tOccurrence.size();

        while (r < s.length()) {
            char c_r = s.charAt(r);

            if (tOccurrence.containsKey(c_r)) {
                int temp = tOccurrence.get(c_r);

                if (--temp == 0) {
                    if (flag > 0) {
                        --flag;
                    }
                }
                tOccurrence.put(c_r, temp);                
            }

            while (l < r) {
                char c_l = s.charAt(l);

                if (tOccurrence.containsKey(c_l) && flag == 0) {
                    int temp = tOccurrence.get(c_l);

                    if (temp < 0) {
                        l++;
                        tOccurrence.put(c_l, ++temp);
                    } 
                    else {
                        break;
                    }
                } 
                else if (!tOccurrence.containsKey(c_l)) {
                    l++;
                } 
                else {
                    break;
                }                
            }

            if (flag == 0) {
                String subStr = s.substring(l, r + 1);

                if (result.length() == 0 || result.length() > subStr.length()) {
                    result = subStr;
                }
            }

            r++;
        }

        return result;
    }
}