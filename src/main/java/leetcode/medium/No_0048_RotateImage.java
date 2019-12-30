package leetcode.medium;

import java.util.Arrays;

/**
 * 旋转1/4正方形
 */
public class No_0048_RotateImage {

  public static void rotate(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }
    int lBound = matrix.length - 1;

    for (int i1 = 0; i1 < (matrix.length + 1) / 2; i1++) {
      for (int j1 = 0; j1 < matrix.length / 2; j1++) {
        int i2 = j1, j2 = lBound - i1;
        int i3 = lBound - i1, j3 = lBound - j1;
        int i4 = lBound - j1, j4 = i1;
        int first = matrix[i1][j1];
        matrix[i1][j1] = matrix[i4][j4];
        matrix[i4][j4] = matrix[i3][j3];
        matrix[i3][j3] = matrix[i2][j2];
        matrix[i2][j2] = first;
      }
    }
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
   *
   * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Rotate Image.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * <p>1错：注意line 17.当面积为偶数时，应该旋转的部分是[0:(matrix.length + 1) / 2]的四分之一正方形</p>
   * <p>但是，当变长为奇数的时候，不能是正方形，否则中轴线就旋转了两次！应该是一个长方形：
   * [0:(matrix.length + 1) / 2, 0: matrix.length / 2</p>
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void test1() {
    int[][] input = new int[4][4];
    input[0] = new int[]{5, 1, 9, 11};
    input[1] = new int[]{2, 4, 8, 10};
    input[2] = new int[]{13, 3, 6, 7};
    input[3] = new int[]{15, 14, 12, 16};

    rotate(input);
    for (int[] line : input) {
      System.out.println(Arrays.toString(line));
    }
  }

  public static void test2() {
    int[][] input = new int[3][3];
    input[0] = new int[]{1, 2, 3};
    input[1] = new int[]{4, 5, 6};
    input[2] = new int[]{7, 8, 9};

    rotate(input);
    for (int[] line : input) {
      System.out.println(Arrays.toString(line));
    }
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}

