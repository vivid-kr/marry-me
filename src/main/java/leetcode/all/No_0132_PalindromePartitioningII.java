package leetcode.all;

import java.util.stream.IntStream;

/**
 * TODO Time
 */
public class No_0132_PalindromePartitioningII {

  public int minCut(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int N = s.length();
    int[] cuts = IntStream.range(0, N).toArray();
    for (int mid = 0; mid < s.length(); mid++) {
      for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end);
          start--, end++) {
        int newCutAtEnd = (start == 0) ? 0 : cuts[start - 1] + 1;
        cuts[end] = Math.min(cuts[end], newCutAtEnd);
      }
      for (int start = mid - 1, end = mid;
          start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
        int newCutAtEnd = (start == 0) ? 0 : cuts[start - 1] + 1;
        cuts[end] = Math.min(cuts[end], newCutAtEnd);
      }
    }
    return cuts[N - 1];
  }

  /**
   * Runtime: 2 ms, faster than 95.53% of Java online submissions for Palindrome Partitioning.
   *
   * Memory Usage: 38.2 MB, less than 100.00% of Java online submissions for Palindrome
   * Partitioning.
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
    No_0132_PalindromePartitioningII no = new No_0132_PalindromePartitioningII();

    System.out.println(no.minCut("aab"));
  }
}

