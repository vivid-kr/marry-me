package leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Time
 */
public class No_0873_LongestFibonacciSubsequence {

  public static int lenLongestFibSubseq(int[] A) {
    if (A.length < 3) {
      return 0;
    }
    Map<Integer, Integer> num2IdxMap = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      num2IdxMap.put(A[i], i);
    }
    int maxLen = 2;

    for (int i = 0; i < A.length - 1 - (maxLen - 2); i++) {
      for (int j = i + 1; j < A.length - (maxLen - 2); j++) {
        int len = 2;
        int a = A[i], b = A[j];
        while (num2IdxMap.containsKey(a + b)) {
          b = a + b;
          a = b - a;
          len++;
        }
        if (len > maxLen) {
          maxLen = len;
        }
      }
    }
    return maxLen == 2 ? 0 : maxLen;
  }

  /**
   * Runtime: 184 ms, faster than 5.10% of Java online submissions for Length of Longest Fibonacci
   * Subsequence.
   *
   * Memory Usage: 39.7 MB, less than 85.71% of Java online submissions for Length of Longest
   * Fibonacci Subsequence.
   *
   * 3次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：line 24: int j = i + 1，错写成了j=i，1，2，3变成了1，1，2
   *
   * 2错：line 32, b = a+b 之后，不能是a = b! b已经变了
   *
   * 3错：line 42, 定义理解错了，如果只有两个数字符合，那么不构成数列
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    System.out.println(5 == lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    System.out.println(3 == lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    System.out.println(5 == lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));
  }
}

