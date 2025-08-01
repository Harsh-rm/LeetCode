class Solution {

    private int result;
    private int[] indegree;

    public int findJudge(int n, int[][] trust) {
        this.result = -1;

        if (trust == null) return result;

        this.indegree = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int[] temp = trust[i];

            indegree[temp[0]] -= 1;
            indegree[temp[1]] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == n - 1 && result == -1) {
                result = i;
            }
        }

        return result;
    }
}