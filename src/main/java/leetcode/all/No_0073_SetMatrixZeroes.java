package leetcode.medium;

/**
 * TODO Time
 */
public class No_0073_SetMatrixZeroes {

  public void setZeroes(int[][] matrix) {
    boolean fr = false, fc = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) {
            fr = true;
          }
          if (j == 0) {
            fc = true;
          }
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (fr) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (fc) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }

  }

  /**
   * Runtime: Memory Usage:
   *
   * 次调试错误，然后成功。
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
    No_0073_SetMatrixZeroes no = new No_0073_SetMatrixZeroes();

    System.out.println(no);
  }
}

