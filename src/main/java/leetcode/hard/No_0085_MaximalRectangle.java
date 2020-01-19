package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Time
 */
public class No_0085_MaximalRectangle {

  public static int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int width = matrix[0].length;
    // compute all ranges in each line
    int[] hist = new int[width];
    int maxArea = 0;

    for (char[] line : matrix) {
      int startIdx = -1;
      for (int i = 0; i <= width; i++) {
        if (i == width || line[i] == '0') {
          if (i < width) {
            hist[i] = 0;
          }
          if (startIdx >= 0) {
            // calc rectangle with n^3
            for (int j = startIdx; j < i; j++) {
              for (int k = startIdx + 1; k <= i; k++) {
                int minHeight = Integer.MAX_VALUE;
                for (int l = j; l < k; l++) {
                  if (hist[l] < minHeight) {
                    minHeight = hist[l];
                  }
                }
                int area = (k - j) * minHeight;
                if (area > maxArea) {
                  maxArea = area;
                }
              }
            }
            // reset
            startIdx = -1;
          }
        } else {
          hist[i]++;
          if (startIdx == -1) {
            startIdx = i;
          }
        }
      }
      System.out.println(Arrays.toString(hist));
    }
    return maxArea;
  }

  /**
   * Runtime: 17 ms, faster than 54.00% of Java online submissions for Maximal Rectangle.
   *
   * Memory Usage: 44.3 MB, less than 23.91% of Java online submissions for Maximal Rectangle.
   *
   * 1次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：在这个解法中，任意两段的最大巨星们面积似乎是O(n^3)的复杂度。有没有更快的？有个韩国解法极其快，在下面
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */

  public static void test1() {
    char[][] input = new char[4][5];
    input[0] = new char[]{'1', '0', '1', '0', '0'};
    input[1] = new char[]{'1', '0', '1', '1', '1'};
    input[2] = new char[]{'1', '1', '1', '1', '1'};
    input[3] = new char[]{'1', '0', '0', '1', '0'};

    int area = maximalRectangle(input);
    System.out.println(area);
  }

  public static void main(String[] args) {
    test1();
  }
}

