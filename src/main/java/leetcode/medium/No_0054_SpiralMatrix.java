package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Time
 */
public class No_0054_SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }
    int rowStep = 1, colStep = 1;
    int row = 0, col = -1;
    final int m = matrix.length, n = matrix[0].length;
    int rowLen = m-1, colLen = n;
    List<Integer> res = new ArrayList<>(m * n);
    for (int s = 0; s < m * n;) {
      for (int i = 0; i < colLen; i++, s++) {
        col += rowStep;
        res.add(matrix[row][col]);
      }
      if (s == m * n) {
        break;
      }
      for (int i = 0; i < rowLen; i++, s++) {
        row += colStep;
        res.add(matrix[row][col]);
      }
      rowLen--;
      colLen--;
      rowStep = -rowStep;
      colStep = -colStep;
    }
    return res;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
   *
   * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Spiral Matrix.
   *
   *
   * 3次调试错误，然后成功。主要是边界处理和循环
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

  public static void test1() {
    No_0054_SpiralMatrix no = new No_0054_SpiralMatrix();
    int[][] matrix = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    System.out.println(no.spiralOrder(matrix));
  }

  public static void main(String[] args) {
    test1();
  }
}

