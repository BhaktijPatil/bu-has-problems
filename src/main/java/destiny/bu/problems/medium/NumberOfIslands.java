package destiny.bu.problems.medium;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        System.out.println(grid.length + " " + grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markIslandAsResolved(grid, i, j);
                    islandCount++;
                    System.out.println("Island : " + islandCount + "\n");
                }
            }
        }
        return islandCount;
    }

    private void markIslandAsResolved(char[][] grid, int i, int j) {
        System.out.println(i + " " + j);
        grid[i][j] = 'x';
        if (i > 0 && grid[i - 1][j] == '1') {
            markIslandAsResolved(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            markIslandAsResolved(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            markIslandAsResolved(grid, i, j - 1);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
            markIslandAsResolved(grid, i, j + 1);
        }
    }
}
