package leetcode.medium;

import java.util.Arrays;

/**
 * TODO Time
 */
public class No_0062_UniquePaths {

  public int uniquePaths(int m, int n) {
    int[] paths = new int[m];
    Arrays.fill(paths, 1);
    System.out.println(Arrays.toString(paths));
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        paths[j] += paths[j - 1];
      }
      System.out.println(Arrays.toString(paths));
    }
    return paths[m - 1];
  }

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
   *
   * Memory Usage: 33.1 MB, less than 5.10% of Java online submissions for Unique Paths.
   *
   *
   * 很明显DP过程太简单，肯定有公式可以直接求的， 在下面 次调试错误，然后成功。
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
  int uniquePaths2(int m, int n) {
    int N = n + m - 2;// how much steps we need to do
    int k = m - 1; // number of steps that need to go down
    double res = 1;
    // here we calculate the total possible path number
    // Combination(N, k) = n! / (k!(n - k)!)
    // reduce the numerator and denominator and get
    // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
    for (int i = 1; i <= k; i++) {
      res = res * (N - k + i) / i;
    }
    return (int) res;
  }

  public static void main(String[] args) {
    No_0062_UniquePaths no = new No_0062_UniquePaths();
    System.out.println(no.uniquePaths(3, 2));
    System.out.println(no.uniquePaths(7, 5));
  }
}

