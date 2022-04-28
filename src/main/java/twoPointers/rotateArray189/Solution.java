package twoPointers.rotateArray189;

import java.util.Arrays;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        int[] nums = { 477181,661861,837383,492412,935349,84343,723642 };
        int k = 3;
        new Solution().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

public class Solution {

//    Solution
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
//  First try
    public void FirstTry(int[] nums, int k) {
        if (nums.length > 1) {
            StringBuilder str = new StringBuilder(Arrays.toString(nums).replace(" ", ""));
            str
                    .deleteCharAt(str.length() - 1)
                    .deleteCharAt(0);
            String lastNumber = "";
            for (int i = 0; i < k; i++) {
                int index = str.lastIndexOf(",");
                lastNumber = str.substring(index + 1);
                str
                        .delete(index, str.length())
                        .insert(0, ",")
                        .insert(0, lastNumber);
            }
            int[] result = Arrays.stream(str.toString().split(",")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(result, 0, nums, 0, nums.length);
        }
    }
//  Second try
    public void SecondTry(int[] nums, int k) {
        if (nums.length > 1) {
            for (int i = 0; i < k; i++) {
                int temp = nums[nums.length - 1];
                for (int j = nums.length - 1; j >= 1; j--) {
                    nums[i] = nums[i - 1];
                }
                nums[0] = temp;
            }
        }
    }
}
