package leetcode.hard;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0085_MaximalRectangle2 {

  public static int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int width = matrix[0].length;
    int[] hist = new int[width + 1];
    int[] stack = new int[width + 2];
    stack[0] = -1;
    int maxArea = 0;
    for (char[] line : matrix) {
      for (int col = 0; col < width; col++) {
        if (line[col] == '1') {
          hist[col]++;
        } else {
          hist[col] = 0;
        }
      }
      maxArea = Math.max(maxArea, calcMaxArea(hist, stack));
    }
    return maxArea;
  }

  private static int calcMaxArea(int[] hists, int[] stack) {
    // init
    int p = 0;
    int area = 0;
    for (int col = 0; col < hists.length; col++) {
      while (p > 0 && hists[stack[p]] > hists[col]) {
        int height = hists[stack[p--]];
        area = Math.max(area, height * (col - stack[p] - 1));
      }
      stack[++p] = col;
    }
    return area;
  }

  /**
   * Runtime: 2 ms, faster than 100.00% of Java online submissions for Maximal Rectangle. Memory
   * Usage: 42.8 MB, less than 89.13% of Java online submissions for Maximal Rectangle.
   *
   * 韩国人的解法。使用栈。将复杂度降到了n^2. 只需要从0到n，如果高度不断增加，则继续。否则，出现了小于上一个高度的值之后，有两个便利条件
   *
   * <p>第一. 不断回退，直到上一个比当前height小的值。由于之前都是递增的，如1，3，4，5，6，2，那么回退到1之前，</p>
   * <p>5的宽度一定是2，3的宽度一定是2，这样就省下了中间宽度的计算</p>
   *
   * <p>第二，回退之后，扔掉了比height还高的部分，那么接下来仍然可以按照类似"回退前"的状态做</p>
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

