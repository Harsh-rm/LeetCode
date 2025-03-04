class Solution {
    private List<List<String>> result;
    //private String s;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        if (s == null || s.length() == 0) return result;

        //this.s = s;
        //Without Index - start the substring from the next index
        helper(s, new ArrayList<>());

        return result;
    }
    
    private void helper(String s, List<String> path) {
        //Base case
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {                
                //Action
                path.add(s.substring(0, i + 1));

                //Recurse
                helper(s.substring(i + 1), path);

                //Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        boolean flag = true;

        while (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (left != right) {
                flag = false;
                return flag;
            }

            i++; j--;
        }

        return flag;
    }
}