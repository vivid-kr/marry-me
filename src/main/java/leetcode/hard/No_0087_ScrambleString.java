package leetcode.hard;

/**
 * TODO Time
 */
public class No_0087_ScrambleString {

  private int hashChar(char[] chars, int st, int len) {
    int res = 0;
    for (int i = 0; i < len; i++) {
      res += chars[st + i] * chars[st + i] * chars[st + i];
    }
    return res;
  }

  private boolean subScramble(char[] s1, char[] s2, int s1St, int s2St, int subLen) {
    if(subLen == 1)
      return s1[s1St] == s2[s2St];
    for (int len1 = 1; len1 < subLen; len1++) {
      //hash the first part of s1
      int hashS11 = hashChar(s1, s1St, len1);
      //hash two parts of s2
      if (hashChar(s2, s2St, len1) == hashS11) {
        if (subScramble(s1, s2, s1St, s2St, len1) &&
            subScramble(s1, s2, s1St + len1, s2St + len1, subLen - len1)) {
          return true;
        }
      }
      if (hashChar(s2, s2St + subLen - len1, len1) == hashS11) {
        if (subScramble(s1, s2, s1St, s2St + subLen - len1, len1) &&
            subScramble(s1, s2, s1St + len1, s2St, subLen - len1)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isScramble(String s1, String s2) {
    char[] s1Array = s1.toCharArray();
    char[] s2Array = s2.toCharArray();
    return subScramble(s1Array, s2Array, 0, 0, s2.length());
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for Scramble String.
   *
   * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Scramble String.
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
    No_0087_ScrambleString no = new No_0087_ScrambleString();

    System.out.println(no.isScramble("great", "rgeat"));
    System.out.println(no.isScramble("great", "rgtae"));
    System.out.println(no.isScramble("abcde", "caebd"));
    System.out.println(no.isScramble("abbbcbaaccacaacc", "acaaaccabcabcbcb"));
  }
}

