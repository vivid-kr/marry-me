package leetcode.medium;

/**
 * TODO Time
 */
public class No_0029_DivideTwoIntegers {

  public static int divide(int A, int B) {
    if (A == 1 << 31 && B == -1) {
      return (1 << 31) - 1;
    }
    int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
    while (a - b >= 0) {
      for (x = 0; a - (b << x << 1) >= 0; x++) {
      }
      res += 1 << x;
      a -= b << x;
    }
    return (A > 0) == (B > 0) ? res : -res;
  }

  /**
   * Referred to Lee215's solution.
   *
   * Runtime:
   *
   * Memory Usage:
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
    System.out.println(3 == divide(10, 3));
  }
}

