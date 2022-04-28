package twoPointers.squaresOfASortedArray977;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        new Solution().sortedSquares(nums);
    }
}

public class Solution {

    public int[] sortedSquares(int[] nums) {
        return Arrays
                .stream(nums)
                .map(el -> (int) Math.pow((float) el, 2))
                .sorted()
                .toArray();
    }
}
