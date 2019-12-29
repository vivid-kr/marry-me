package leetcode.hard;

/**
 * TODO Time
 */
public class No_0044_WildcardMatching {

  public boolean isMatch2(String s, String p) {
    // replace multiple * with single *
    char[] sArray = s.toCharArray(), pArray = p.toCharArray();
    int writeIndex = 0;
    boolean isFirst = true;
    for (int i = 0; i < pArray.length; i++) {
      if (pArray[i] == '*') {
        if (isFirst) {
          pArray[writeIndex++] = pArray[i];
          isFirst = false;
        }
      } else {
        pArray[writeIndex++] = pArray[i];
        isFirst = true;
      }
    }

    // initiate dp array
    int m = sArray.length, n = writeIndex;
    boolean[][] dp = new boolean[m + 1][n + 1];

    // s and p are all empty, they match
    dp[0][0] = true;

    // s is empty and p is *, they match
    if (n > 0 && pArray[0] == '*') {
      dp[0][1] = true;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        // add j>0 to make first column false, because pattern is empty but text is not
        if (j > 0 && (sArray[i - 1] == pArray[j - 1] || pArray[j - 1] == '?')) {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (j > 0 && pArray[j - 1] == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[m][n];
  }

  /**
   * Runtime: 2 ms, faster than 99.98% of Java online submissions for Wildcard Matching.
   *
   * Memory Usage: 40.2 MB, less than 44.19% of Java online submissions for Wildcard Matching.
   *
   * 多次调试错误，然后成功。注意：替换***为*，很重要！
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

  /**
   * 以下解法超时了
   */
  public boolean subMatch(char[] s, char[] p, int sPos, int pPos, final int sLen, final int pLen) {
    if (pPos == pLen) {
      return sPos == sLen;
    }
    if (p[pPos] == '*') {
      return (sPos<sLen && subMatch(s, p, sPos + 1, pPos, sLen, pLen)) || (subMatch(s, p, sPos, pPos + 1, sLen, pLen));
    } else {
      boolean firstMatch = sPos < sLen && (p[pPos] == '?' || s[sPos] == p[pPos]);
      return firstMatch && subMatch(s, p, sPos + 1, pPos + 1, sLen, pLen);
    }
  }

  public boolean isMatch(String s, String p) {
    // replace multiple * with single *
    char[] sArray = s.toCharArray(), pArray = p.toCharArray();
    int writeIndex = 0;
    boolean isFirst = true;
    for (int i = 0; i < pArray.length; i++) {
      if (pArray[i] == '*') {
        if (isFirst) {
          pArray[writeIndex++] = pArray[i];
          isFirst = false;
        }
      } else {
        pArray[writeIndex++] = pArray[i];
        isFirst = true;
      }
    }
    int sLen = sArray.length, pLen = writeIndex;
    return subMatch(sArray, pArray, 0, 0, sLen, pLen);
  }

  public static void main(String[] args) {
    No_0044_WildcardMatching no = new No_0044_WildcardMatching();

    System.out.println(no.isMatch("aa", "a"));
    System.out.println(no.isMatch("aa", "*"));
  }
}

