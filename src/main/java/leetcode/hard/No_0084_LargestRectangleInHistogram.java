package leetcode.hard;

/**
 * TODO Time
 */
public class No_0084_LargestRectangleInHistogram {

  public static int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int l = heights.length;
    int[] stack = new int[l + 2];
    int maxArea = 0;
    int p = 0;
    stack[0] = -1;
    for (int i = 0; i <= l; i++) {
      int h = (i == l) ? 0 : heights[i];
      while (p > 0 && h < heights[stack[p]]) {
        int minH = heights[stack[p--]];
        maxArea = Math.max(maxArea, minH * (i - stack[p] - 1));
      }
      stack[++p] = i;
    }
    return maxArea;
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
    System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
  }
}

