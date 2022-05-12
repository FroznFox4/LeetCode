package binarySearch.SearchInRotatedSortedArray33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] n = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int mew = Solution.getInstance().search(n, target);
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

    public int search(int[] arr, int target) {
        //Find the index of pivot(i.e the element with highest vaule/ where array is rotated)
        int pivot = Pivot(arr);
        int ans =  BinarySearch(arr ,target, 0, pivot);
        if(ans==-1)
            ans = BinarySearch(arr, target, pivot+1, arr.length-1);
        return ans;
    }
    public int Pivot(int[] arr){

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            //4 cases
            if(mid<end && arr[mid]>arr[mid+1])
                return mid;
            if(mid>start && arr[mid-1]>arr[mid])
                return mid-1;
            if(arr[mid]>arr[start])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
    public int BinarySearch(int[] arr, int target, int start, int end){
        int ans = -1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>target){
                end = mid-1;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }
            else {
                return mid;
            }
        }
        return ans;
    }

    public int searchMy(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}