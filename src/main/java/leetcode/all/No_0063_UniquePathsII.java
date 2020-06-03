package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0063_UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }
    int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {
      return 0;
    }
    int[] paths = new int[m];
    Arrays.fill(paths, 1);
    for (int j = 1; j < m; j++) {
      if (obstacleGrid[0][j] == 1) {
        for (int i = j; i < m; i++) {
          paths[i] = 0;
        }
      }
    }
    for (int i = 1; i < n; i++) {
      if (obstacleGrid[i][0] == 1) {
        paths[0] = 0;
      }
      for (int j = 1; j < m; j++) {
        if (obstacleGrid[i][j] == 1) {
          paths[j] = 0;
        } else {
          paths[j] += paths[j - 1];
        }
      }
    }
    return paths[m - 1];
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
   *
   * Memory Usage: 40.4 MB, less than 35.38% of Java online submissions for Unique Paths II.
   *
   *
   *
   * 错误：
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
    No_0063_UniquePathsII no = new No_0063_UniquePathsII();
    System.out.println(no.uniquePathsWithObstacles(new int[][]{{0, 1, 0}, {0, 0, 0}}));

  }
}

