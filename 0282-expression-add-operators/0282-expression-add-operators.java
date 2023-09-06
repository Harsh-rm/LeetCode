class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<String>();

        if (num == null || num.length() == 0) return result;

        helper(num, target, 0, "", 0, 0);

        return result;
    }

    public void helper(String num, int target, int index, String path, long calc, long tail) {
        //base case
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }
        //logic to capture all sequences
        for(int i = index; i < num.length(); i++) {
            // handles expressions with preceding 0s i.e "01" => parseLong = 1
            if (index != i && num.charAt(index) == '0') continue;
            //start from index 0 until index i for the substring
            long curr =  Long.parseLong(num.substring(index, i + 1)); //captures substring until ith position
            // capture a null path "" and start from the curr value of the substring
            // i.e ("" + 1) , ("" + 12) , ("" + 123)
            if (index == 0) { // to avoid adding operators in the beginning
                helper(num, target, i + 1, path + curr, curr, curr);
            } else { // start adding operators in between the expression
                // + operator case
                helper(num, target, i + 1, path + "+" + curr, calc + curr, +curr);
                // - operator case
                helper(num, target, i + 1, path + "-" + curr, calc - curr, -curr);
                // * operator case
                helper(num, target, i + 1, path + "*" + curr, calc - tail + tail * curr, tail*curr);
            }
        }
    }
}