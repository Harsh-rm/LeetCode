class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> generate(int numRows) {
        result = new ArrayList<>();

        if (numRows == 0) return result;

        helper(numRows);

        return result;
    }

    private void helper(int numRows) {
        //Base
        if (numRows == 1) {
            result.add(new ArrayList<>(Arrays.asList(1)));
            return;
        }

        //Logic
        helper(numRows - 1);

        ArrayList<Integer> currRow = new ArrayList<>();

        currRow.add(1);
        for (int j = 1; j < numRows - 1; j++) {
            currRow.add(result.get(numRows - 2).get(j - 1) + result.get(numRows - 2).get(j));
        }
        currRow.add(1);

        result.add(currRow);
    }
}