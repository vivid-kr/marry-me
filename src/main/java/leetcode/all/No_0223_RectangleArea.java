package leetcode.all;

/**
 * TODO Time
 */
public class No_0223_RectangleArea {

  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int rectOne = (C - A) * (D - B);
    int rectTwo = (G - E) * (H - F);

    if (A >= G || B >= H || C <= E || D <= F) {
      return rectOne + rectTwo;
    }

    int length = Math.min(C, G) - Math.max(A, E);
    int height = Math.min(D, H) - Math.max(B, F);

    return rectOne + rectTwo - length * height;
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum
   * of Digits of an Integer.
   *
   * Memory Usage: 33.2 MB, less than 100.00% of Java online submissions for Subtract the Product
   * and Sum of Digits of an Integer.
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
    No_0223_RectangleArea no = new No_0223_RectangleArea();

    System.out.println(no);
  }
}

