package dynamicProgramming.climbingStairs70;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int mew = Solution.getInstance().climbStairs(n);
        System.out.println(mew);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

    //    Memory the best solution
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        //cc
        if (n <= 2) {
            return n;
        }
        return count(n);
    }

    public int count(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = count(n - 1) + count(n - 2);
        return memo[n];
    }

    //    My solution
    public int climbStairsMy(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}