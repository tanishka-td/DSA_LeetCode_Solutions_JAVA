class Solution {
    int[] stoneValue;
    Integer[] dp;
    int n;
    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        this.n = stoneValue.length;
        this.dp = new Integer[n];
        int diff = solve(0);
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
    private int solve(int i) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int k=0; k<3 && i+k<n; k++){
            sum += stoneValue[i+k];
            ans = Math.max(ans, sum-solve(i+k+1));
        }
        return dp[i] = ans;
    }
}