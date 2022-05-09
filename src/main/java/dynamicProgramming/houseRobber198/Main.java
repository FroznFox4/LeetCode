package dynamicProgramming.houseRobber198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] n = {0,2,3,2,4,5};
        int mew = Solution.getInstance().rob(n);
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

//    O(1)
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp = {nums[0], Math.max(nums[0], nums[1])};
        for(int i=2; i<nums.length; i++){
            int index = i&1; // i&1 === i%2.  //index^1: 0->1, 1->0.
            dp[index] = Math.max(nums[i]+dp[index], dp[index^1]);
        }
        return Math.max(dp[0], dp[1]);
    }

//    My solution
    public int robMy(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 2)
                nums[i] = Math.max(nums[i - 3], nums[i - 2]) + nums[i];
            else if (i == 2)
                nums[i] = nums[i - 2] + nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}