//Leetcode Premium problem - code goes here...
//Description - Paint Houses with minimum cost, by selecting from the costs for each house (as rows) from the m x 3 matrix. 
// The three columns represent the colors R, G, and B. The constraint is that no two adjacent houses can be of the same color.

//Recursive Solution
class Solution {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;

    //Red = 0, Green = 1, Blue = 2
    int caseRed = helper(costs, 0, 0, 0);
    int caseGreen = helper(costs, 0, 1, 0);
    int caseBlue = helper(costs, 0, 2, 0);

    return Math.min(caseRed, Math.min(caseGreen, caseBlue));
  }

  private int helper(int[][] costs, int index, int color, int amount) {
  //Base case
  if (index == costs.length) {
    return amount;
  }
  
  //logic - exhaustively iterate from the first house for each color until the last house and return the minimum cost
  if (color == 0) { //Red case starting from the first house (as index 0 in this scenario)
    return Math.min(helper(costs, index + 1, 1, amount + costs[index][0]), helper(costs, index + 1, 2, amount + costs[index][0]);
  }
  if (color == 1) { //Green case starting from the first house (as index 0 in this scenario)
    return Math.min(helper(costs, index + 1, 0, amount + costs[index][1]), helper(costs, index + 1, 2, amount + costs[index][1]);
  }
  if (color == 2) { //Blue case starting from the first house (as index 0 in this scenario)
    return Math.min(helper(costs, index + 1, 0, amount + costs[index][2]), helper(costs, index + 1, 1, amount + costs[index][2]);
  }
  return Integer.MAX_VALUE;
  }
}

//Dynamic Programming Solution
class Solution {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;

    int m = costs.length;
    int[][] dp = new int[m][3];
    
    for (int j = 0; j < 3; j++) {
      dp[m - 1][j] = costs[m - 1][j];
    }

    //Perform Dynamic programming, by breaking down the repeated sub-problems into the dp array
    for (int i = m - 2; i >= 0; i--) {
      dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
      dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
      dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
    }

    int min = Integer.MAX_VALUE;
    for (int j = 0; j < 3; j++) {
      if (dp[0][j] < min) {
        min = dp[0][j];
      }
    }

    return min;
  }
}
