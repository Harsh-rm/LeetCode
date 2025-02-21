class Solution {
    private List<String> result;
    private String num;
    private int target;
    private char[] operands;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();

        if (num == null || num.length() == 0) return result;

        this.num = num;
        this.target = target;
        operands = new char[] {'+', '-', '*'};

        helper(0, "", 0, 0);

        return result;
    }

    private void helper(int index, String path, long calculatedVal, long lastOperation) {
        //Base case
        if (index == num.length()) {
            if (calculatedVal == target) {
                result.add(new String(path));
            }
            return;
        }
        //Logic
        for (int i = index; i < num.length(); i++) {
            if (index != i && num.charAt(index) == '0') continue;

            long curr = Long.parseLong(num.substring(index, i + 1));            

            if (index == 0) {
                helper(i + 1, path + curr, curr, curr);
            }
            else {
                //+ operator case
                helper(i + 1, path + operands[0] + curr, calculatedVal + curr, curr);
                //- operator case
                helper(i + 1, path + operands[1] + curr, calculatedVal - curr, -curr);
                //* operator case
                long temp = lastOperation * curr;
                helper(i + 1, path + operands[2] + curr, calculatedVal - lastOperation + temp, temp);
            }
        }
    }
}