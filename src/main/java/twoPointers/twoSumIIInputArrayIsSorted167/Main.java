package twoPointers.twoSumIIInputArrayIsSorted167;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = { 2,3,4 };
        int target = 6;
        System.out.println(Arrays.toString(Solution.getInstance().twoSum(nums, target)));
    }


}
class Solution {

    private Solution(){}

    private static Solution obj = new Solution();

    public static Solution getInstance()
    {
        return obj;
    }

//    66% Speed 66% memory
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int ans[]=new int[2];
        int j=numbers.length-1;
        while(i<=j){
            if(numbers[i]+numbers[j]==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
            else if(numbers[i]+numbers[j]>target){
                j--;
            }
            else {
                i++;
            }
        }
        return ans;
    }
//    20% Speed 90% memory
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = { 0, 0 };
        int k = numbers.length;
        for (int j = 0; j < numbers.length - 1; j++) {
            int addNumber = target - numbers[j];
            int number = Arrays.binarySearch(numbers, j + 1, k, addNumber);
            if (number > 0) {
                result[0] = j + 1;
                result[1] = number + 1;
            }
        }
        return result;
    }
}