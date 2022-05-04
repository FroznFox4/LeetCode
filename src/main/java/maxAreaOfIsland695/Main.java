package maxAreaOfIsland695;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int mew = Solution.getInstance().maxAreaOfIsland(grid);
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

//    Runtime: 11 ms, faster than 8.05%; Memory Usage: 45.1 MB, less than 72.33%
    public int maxAreaOfIsland(int[][] grid) {
        int[][] gridMutation = grid.clone();
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ( grid[i][j] != 0 ) {
                    int sizeIsland = calculateAreaOfIsland(gridMutation, i, j);
                    if (sizeIsland > max) max = sizeIsland;
                }
            }
        }
        return max;
    }

    private int calculateAreaOfIsland(int[][] island, int sr, int sc) {
        int count = 1;
        final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc } );
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : directions) {
                int row = cur[0] + dir[1];
                int col = cur[1] + dir[0];
                if (isValidIsland(row, col, island)) {
                    island[row][col] = 0;
                    count++;
                    queue.add(new int[] { row, col } );
                }
            }
        }
        return (count > 1) ? --count : count;
    }

    private boolean isValidIsland( int row, int col, int[][] island ){
        return row < island.length && row >= 0 && col < island[0].length && col >= 0 && island[row][col] != 0;
    }
}