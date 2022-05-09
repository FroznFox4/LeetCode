package dynamicProgramming.triangle120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(
                List.of(
                        List.of(2),
                        List.of(3, 4),
                        List.of(6, 5, 7),
                        List.of(4, 1, 8, 3)
                ));
        int mew = Solution.getInstance().minimumTotal(triangle);
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

//    Faster solution
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cache = new int[triangle.size() + 1];
        dp(cache, triangle, triangle.size() - 1);
        return cache[0];
    }

    public void dp(int[]cache, List<List<Integer>> triangle, int i){
        if (i >= 0){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j <= i; j++){
                cache[j] = list.get(j) + Math.min(cache[j], cache[j+1]);
            }
            dp(cache, triangle, i - 1);
        }
    }

//    My solution
    public int minimumTotalMy(List<List<Integer>> triangle) {
        int min = 0;
        for (int i = 0; i < triangle.size(); i++)
            if (i == 0)
                min = triangle.get(i).get(i);
            else {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    if (j == 0) {
                        triangle.get(i).set(
                                j,
                                triangle.get(i - 1).get(j) + triangle.get(i).get(j)
                        );
                    } else if (j == triangle.get(i).size() - 1) {
                        triangle.get(i).set(
                                j,
                                triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j)
                        );
                    } else {
                        triangle.get(i).set(
                                j,
                                Math.min(
                                        triangle.get(i - 1).get(j - 1),
                                        triangle.get(i - 1).get(j)
                                ) + triangle.get(i).get(j)
                        );
                    }
                }
            }
        for (int i = 0; i < triangle.size(); ++i) {
            min = Math.min(min, triangle.get(triangle.size() - 1).get(i));
        }
        return min;
    }
}