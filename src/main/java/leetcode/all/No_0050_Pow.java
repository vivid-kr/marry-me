package leetcode.medium;

import java.util.Map;

/**
 * TODO Time
 */
public class No_0050_Pow {

  public double myPow(double x, int n) {
    if (x == 0 || x == 1) {
      return 0;
    }
    double logMaxInf = Math.log(1.79769) + 308 * Math.log(308);
    double logMinInf = Math.log(2.22507) - 308 * Math.log(308);
    double logX = n * Math.log(Math.abs(x));
    if (logX > logMaxInf) {
      return x < 0 && (n % 2 == 1) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    }
    if (logX < logMinInf) {
      return 0;
    }
    double base = 1;
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    for (int i = 0; i < n; i++) {
      base *= x;
    }
    return base;
  }

  /**
   * Runtime: 5 ms, faster than 6.08% of Java online submissions for Pow(x, n).
   *
   * Memory Usage: 35.7 MB, less than 5.88% of Java online submissions for Pow(x, n). Next
   * challenges:
   *
   * 2次调试错误，然后成功。这个做法有点笨，下面那个基于2分解的比较好
   *
   * 错误：笔误，加上忽视了-1为base。
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */
  public double myPow2(double x, int n) {
    if (n == 0) {
      return 1;
    }
    double pow = myPow2(x, n / 2);
    if (n > 0) {
      if (n % 2 == 0) {
        return pow * pow;
      } else {
        return x * pow * pow;
      }
    } else if (n % 2 == 0) {
      return pow * pow;
    } else {
      return (1 / x) * pow * pow;
    }
  }

  public static void main(String[] args) {
    No_0050_Pow no = new No_0050_Pow();

    System.out.println(no.myPow(2000.00000, 2147483647));
    System.out.println(no.myPow(2, 3));
    System.out.println(no.myPow(200, 308));
    System.out.println(no.myPow(0.3, 5));
    System.out.println(no.myPow(-0.3, 5));
    System.out.println(no.myPow(-0.3, -5));
    System.out.println(no.myPow(0.3, -5));
  }
}

