package recursionOrBacktracking.permutations46;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> mew = Solution.getInstance().permute(nums);
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

//    The best optimization
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        collect(nums, 0, result);
        return result;
    }

    private void collect(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            collect(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private List<Integer> toList(int[] arr) {
        var result = new ArrayList<Integer>();
        for (int n : arr) result.add(n);
        return result;
    }

//    Second optimization
    public List<List<Integer>> permuteThree(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new LinkedHashSet<>(), nums);
    return ret;
}

    private void dfs(List<List<Integer>> ret, Set<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.add(num)) {
                dfs(ret, path, nums);
                path.remove(num);
            }
        }
    }

//    Optimization
    public List<List<Integer>> permuteSecond(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, new ArrayList<>(), new HashSet<>(), nums);
        return ret;

    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tmpList, Set<Integer> tmpSet, int[] nums) {
        if (tmpSet.size() == nums.length) {
            ret.add(new ArrayList<>(new ArrayList<>(tmpList)));
            return;
        }
        for (int num : nums) {
            if (tmpSet.contains(num)) continue;
            tmpSet.add(num);
            tmpList.add(num);
            backtrack(ret, tmpList, tmpSet, nums);
            tmpSet.remove(tmpList.get(tmpList.size() - 1));
            tmpList.remove(tmpList.size() - 1);
        }
    }

//    First Solution

    public List<List<Integer>> permuteFirst(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if ( tempList.size() == nums.length ) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}