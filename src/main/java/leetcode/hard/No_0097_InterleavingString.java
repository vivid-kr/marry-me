package leetcode.hard;

/**
 * TODO Time
 */
public class No_0097_InterleavingString {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }
    boolean dp[] = new boolean[s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) {
          dp[j] = true;
        } else if (i == 0) {
          dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        } else if (j == 0) {
          dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
        } else {
          dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1]
              && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }
      }
    }
    return dp[s2.length()];
  }


  /**
   * Runtime: 2 ms, faster than 85.01% of Java online submissions for Interleaving String.
   *
   * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Interleaving String.
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
    No_0097_InterleavingString no = new No_0097_InterleavingString();
    System.out.println(no.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
}

