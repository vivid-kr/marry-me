package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0059_SpiralMatrixII {

  public int[][] generateMatrix(int n) {
    int rowStep = 1, colStep = 1;
    int row = 0, col = -1;
    final int m = n;
    int rowLen = m - 1, colLen = n;
    int[][] matrix = new int[n][n];
    for (int s = 1; s <= m * n; ) {
      for (int i = 0; i < colLen; i++, s++) {
        col += rowStep;
        matrix[row][col] = s;
      }
      if (s == m * n) {
        break;
      }
      for (int i = 0; i < rowLen; i++, s++) {
        row += colStep;
        matrix[row][col] = s;
      }
      rowLen--;
      colLen--;
      rowStep = -rowStep;
      colStep = -colStep;
    }
    return matrix;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
   *
   * Memory Usage: 34.2 MB, less than 8.33% of Java online submissions for Spiral Matrix II.
   *
   *
   * 0次调试错误，然后成功。memory不用管
   *
   * 错误：
   *
   * 1错：line 24,25. 注意，要先更新行列idx，再put。否则for循环出去的时候，idx就越界了
   *
   * 2错：line20: 如果在循环体内部更新标号，那么for中就不要再有了，否则一定要算清楚
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void test1(int n) {
    No_0059_SpiralMatrixII no = new No_0059_SpiralMatrixII();
    System.out.println(n);
    int[][] res = no.generateMatrix(n);
    for (int[] re : res) {
      System.out.println(Arrays.toString(re));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    test1(3);
    test1(1);
    test1(5);
  }
}

