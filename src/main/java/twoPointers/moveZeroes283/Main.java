package twoPointers.moveZeroes283;

import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        int[] nums = { 0 };
        Solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
//    Solution
    public static void moveZeroes(int[] nums) {
        int left = 0;
        //Loop through and place all non-zero values at the beginning, moving the left index for each
        //non-zero value.
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[left] = nums[i];
                left++;
            }
        }

        //after moving all the non-zero values at the beginning, set the rest of the array to 0.
        while(left<nums.length)
            nums[left++] = 0;
    }

//  First try
    public static void moveZeroesFirst(int[] nums) {
        if (nums.length == 0) return;
        int curZero = getFirstElemets(nums) - 1;
        if (curZero == -1 ) return;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && curZero < i) {
                int temp = nums[i];
                nums[i] = 0;
                nums[curZero] = temp;
                i = getFirstElemets(nums) - 1;
                curZero = i;
                if (i == -1) return;
            }
        }
    }
    public static int getFirstElemets(int[] nums) {
        int position = 1;
        for (int n : nums) {
            if (n == 0) {
                return position;
            }
            position += 1;
        }
        return position;
    }
}
