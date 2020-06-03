package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0064_MinimumPathSum {

  public int minPathSum(int[][] grid) {
    for (int[] ints : grid) {
      System.out.println(Arrays.toString(ints));
    }
    System.out.println();
    int n = grid.length;
    int m = grid[0].length;

    for (int i = 1; i < m; i++) {
      grid[0][i] += grid[0][i - 1];
    }
    for (int i = 1; i < n; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
      }
    }
    for (int[] ints : grid) {
      System.out.println(Arrays.toString(ints));
    }
    return grid[n - 1][m - 1];
  }

  /**
   * Runtime: 2 ms, faster than 90.68% of Java online submissions for Minimum Path Sum.
   *
   * Memory Usage: 43.2 MB, less than 39.19% of Java online submissions for Minimum Path Sum.
   *
   *
   * 错误：笔误。另外，利用参数做in-place操作，没有任何额外分配空间居然是40%，有点扯
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void main(String[] args) {
    No_0064_MinimumPathSum no = new No_0064_MinimumPathSum();
    System.out.println(no.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));

  }
}

