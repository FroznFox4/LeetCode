package breadthFirstSearchOrDepthFirstSearch.floodFill733;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int[][] image = { { 1,1,1}, {1,1,0}, {1,0,1} };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] mew = Solution.getInstance().floodFill(image,sr,sc,newColor);
        System.out.println(Arrays.deepToString(mew));
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        image[sr][sc] = newColor;
        if (target == newColor) {
            return image;
        }
        final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : directions) {
                int row = cur[0] + dir[1];
                int col = cur[1] + dir[0];
                if (isValid(row, col, image, target)) {
                    image[row][col] = newColor;
                    queue.add(new int[]{row,col});
                }
            }
        }
        return image;
    }
    private boolean isValid(int row,int col,int[][] image,int target){
        return row < image.length && row >= 0 && col < image[0].length && col >= 0 && image[row][col] == target;
    }
}