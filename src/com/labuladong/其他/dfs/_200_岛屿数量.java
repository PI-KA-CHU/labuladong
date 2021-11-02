package com.labuladong.其他.dfs;

public class _200_岛屿数量 {

    /**
     * dfs
     * 思路：遍历每个格子，符合条件则岛屿+1，然后把所有相邻的岛屿都置为2
     *
     * 时间：O(m*n)
     * 空间：O(m*n)：最坏情况下整个网格都是岛屿
     *
     */
    public int numIslands(char[][] grid) {

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans ++;
                    traverse(grid, i, j);
                }
            }
        }

        return ans;
    }

    public void traverse(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        traverse(grid, i - 1, j);
        traverse(grid, i + 1, j);
        traverse(grid, i, j - 1);
        traverse(grid, i, j + 1);
    }

}
