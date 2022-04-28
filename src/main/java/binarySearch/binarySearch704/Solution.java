package binarySearch.binarySearch704;

public class Solution {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 0;
        Solution.search(nums, target);
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int s = 0;
        int end = nums.length-1;
        while(s<=end){
            int mid = s + (end - s) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]<target){
                s = mid+1;
            }
            if(nums[mid]>target){
                end = mid-1;
            }
        }
        return -1;
    }
}