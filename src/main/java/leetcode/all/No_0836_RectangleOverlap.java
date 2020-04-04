package leetcode.all;

/**
 * TODO Time
 */
public class No_0836_RectangleOverlap {

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rectangle Overlap.
   *
   * Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Rectangle Overlap.
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
    No_0836_RectangleOverlap no = new No_0836_RectangleOverlap();

    System.out.println(no);
  }
}

