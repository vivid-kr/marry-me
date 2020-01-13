package leetcode.hard;

/**
 * TODO Time
 */
public class No_0076_MinimumWindowSubstring {

  public static String minWindow(String s, String t) {
    int[] cnt = new int[225];
    for (int i = 0; i < 225; i++) {
      cnt[i] = Integer.MIN_VALUE;
    }
    int c;
    int tLen = t.length();
    int sLen = s.length();
    char[] cS = s.toCharArray();
    char[] cT = t.toCharArray();

    for (int i = 0; i < tLen; i++) {
      c = cT[i] - (char)0;
      if (cnt[c] == Integer.MIN_VALUE) {
        cnt[c] = 0;
      }
      cnt[c]++;
    }

    int i = 0;
    int j = 0;
    int okNum = 0;
    int bestLen = sLen + 1;
    int bestI = 0;
    int bestJ = 0;
    int tmp;
    boolean found = false;
    while (j < sLen || (j == sLen && okNum == tLen)) {
      if (okNum < tLen) {
        c = cS[j++] - (char)0;
        if (cnt[c] > Integer.MIN_VALUE) {
          tmp = cnt[c];
          if (tmp > 0) {
            okNum++;
          }
          cnt[c] = tmp - 1;
        }
      }
      else {
        c = cS[i++] - (char)0;
        if (cnt[c] > Integer.MIN_VALUE) {
          tmp = cnt[c];
          if (tmp >= 0) {
            okNum--;
          }
          cnt[c] = tmp + 1;
        }
      }
      if (okNum == tLen && bestLen > j - i) {
        bestLen = j - i;
        bestI = i;
        bestJ = j;
        found = true;
      }
    }
    if (!found) {
      return "";
    }
    return s.substring(bestI, bestJ);
  }
  /**
   * 借鉴自 https://leetcode.com/problems/minimum-window-substring/discuss/26903/5ms-Java-solution
   * A little tired. Sorry for this problem.
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
    String expect = "BANC";
    String actual = minWindow("ADOBECODEBANC", "ABC");

    System.out.println(actual);
    System.out.println(expect.equals(actual));
  }
}

