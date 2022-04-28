package binarySearch.searchInsertPosition35;

public class Solution {

    public static void main(String[] args) {
        SolutionTwo solutionTwo = new SolutionTwo();
        int[] nums = { 1, 3, 5, 7};
        int target = 6;
        solutionTwo.searchInsert(nums, target);
    }
}

class SolutionTwo {
    public int searchInsert(int[] nums, int target) {
        if ( nums.length == 0 )
            return 0;
        int s = 0;
        int end = nums.length - 1;
        while ( s <= end ) {
            int mid = s + (end - s) / 2;
            if ( nums[mid] == target ) {
                return mid;
            }
            if ( nums[mid] < target ){
                s = mid+1;
            }
            if ( nums[mid] > target ){
                end = mid-1;
            }
        }
        return end;
    }
}