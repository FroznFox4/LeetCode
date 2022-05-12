package binarySearch.findFirstAndLastPositionOfElementInSortedArray34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] n = {1,2,3,0};
        int target = 0;
        int[] mew = Solution.getInstance().searchRange(n, target);
        System.out.println(Arrays.toString(mew));
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

    public int[] searchRangeMy(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int index = Arrays.binarySearch(nums, target);
        if (nums.length == 1 && nums[0] == target)
            return new int[]{0,0};
        else if (index == (nums.length - 1) && nums.length > 0)
            while (nums[index] == target)
                result.add(index--);
        else if ( index > 0 ) {
            int leftIndex = index - 1;
            while (index < nums.length && nums[index] == target)
                result.add(index++);
            while (leftIndex > -1 && nums[leftIndex] == target)
                result.add(0, leftIndex--);
        } else if (index == 0)
            while (index < nums.length && nums[index] == target)
                result.add(index++);
        else
            result.addAll(List.of(-1,-1));
        if (result.size() == 1) {
            result.add(result.get(0));
        }
        while (result.size() > 2 ) {
            result.remove(1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] searchRange(int[] nums, int target) {
        int first=-1;
        int last=-1;
        int left=0, right=nums.length-1;
        int mid;
        while(left<=right)
        {
            mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                right=mid-1;
                first=mid;
            }
            else if(nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        left=0; right=nums.length-1;
        while(left<=right)
        {
            mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                left=mid+1;
                last=mid;
            }
            else if(nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        int[] output=new int[2];
        output[0]=first;
        output[1]=last;
        return output;

    }
}