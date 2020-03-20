package leetcode.all;

/**
 * TODO Time
 */
public class No_0509_FibonacciNumber {

  public static int fib(int N) {
    if (N <= 1) {
      return N;
    }
    int a = 0;
    int b = 1;
    for (int i = 2; i <= N; i++) {
      b = a + b;
      a = b - a;
    }
    return b;
  }

  /**
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
    System.out.println(3 == fib(4));
//    System.out.println(actual);
//    System.out.println(expect.equals(actual));
  }
}

