package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0059_SpiralMatrixIII {

  public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    if (r0 < 0 || r0 >= R || c0 < 0 || c0 >= C) {
      return null;
    }

    int rowStep = 1, colStep = 1;
    int row = r0, col = c0;
    int walkLen = 1;
    int passNum = 1;

    int[][] res = new int[R * C][2];
    res[0][0] = r0;
    res[0][1] = c0;
    while (passNum <= R * C) {
      for (int i = 0; i < walkLen; i++) {
        col += rowStep;
        if (row >= 0 && row < R && col >= 0 && col < C) {
          res[passNum][0] = row;
          res[passNum][1] = col;
          passNum++;
        }
      }
      if (passNum == R * C) {
        break;
      }
      for (int i = 0; i < walkLen; i++) {
        row += colStep;
        if (row >= 0 && row < R && col >= 0 && col < C) {
          res[passNum][0] = row;
          res[passNum][1] = col;
          passNum++;
        }
      }
      walkLen++;
      rowStep = -rowStep;
      colStep = -colStep;
    }
    return res;
  }

  /**
   * Runtime: 3 ms, faster than 97.91% of Java online submissions for Spiral Matrix III.
   *
   * Memory Usage: 38.4 MB, less than 12.50% of Java online submissions for Spiral Matrix III.
   *
   * 0次调试错误，然后成功。memory不用管，反正是常数级别。快速解决掉
   *
   * 错误：
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void test1(int R, int C, int r0, int c0) {
    No_0059_SpiralMatrixIII no = new No_0059_SpiralMatrixIII();
    int[][] res = no.spiralMatrixIII(R, C, r0, c0);
    for (int[] re : res) {
      System.out.print(Arrays.toString(re));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    test1(1, 4, 0, 0);
    test1(5, 6, 1, 4);
  }
}

