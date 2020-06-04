package leetcode.easy;

import java.util.Map;

/**
 * TODO Time
 */
public class No_0070_ClimbingStairs {

  public static int climbStairs(int n) {
    if (n < 3) {
      return n;
    }
    int[] ways = new int[n + 1];
    ways[1] = 1;
    ways[2] = 2;
    for (int i = 3; i <= n; i++) {
      ways[i] = ways[i - 1] + ways[i - 2];
    }
    return ways[n];
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
    System.out.println(climbStairs(3));
  }
}

