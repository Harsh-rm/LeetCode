class Solution {
    private List<List<String>> result;
    private String s;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        if (s == null || s.length() == 0) return result;

        this.s = s;

        helper(0, new ArrayList<>());

        return result;
    }

    private void helper(int index, List<String> path) {
        //Base case
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {                
                //Action
                //path.add(s.substring(index, i + 1));
                List<String> newList = new ArrayList<>(path);
                newList.add(s.substring(index, i + 1));

                //Recurse
                helper(i + 1, newList);

                //Backtrack
                //path.remove(path.size() - 1);
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