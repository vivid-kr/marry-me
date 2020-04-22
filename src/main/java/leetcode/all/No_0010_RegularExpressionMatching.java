package leetcode.hard;

/**
 * TODO Time
 */
public class No_0010_RegularExpressionMatching {

  public static boolean subMatch(String s, String p, int sPos, int pPos) {
    if (pPos == p.length()) {
      return sPos == s.length();
    }
    boolean firstMatch =
        sPos < s.length() && (p.charAt(pPos) == '.' || s.charAt(sPos) == p.charAt(pPos));
    if (pPos < p.length() - 1 && p.charAt(pPos + 1) == '*') {
      return (firstMatch && subMatch(s, p, sPos + 1, pPos)) || (subMatch(s, p, sPos, pPos + 2));
    } else {
      return firstMatch && subMatch(s, p, sPos + 1, pPos + 1);
    }
  }

  public static boolean isMatch(String s, String p) {
    return subMatch(s, p, 0, 0);
  }

  /**
   * Runtime: 12 ms, faster than 32.03% of Java online submissions for Regular Expression Matching.
   * Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Regular Expression
   * Matching.
   *
   * 3次调试错误，然后成功。
   *
   * 错误：
   *
   * 1错：有一次超时了，其他几次想得有点复杂，这个答案是看过solution之后，自己重写的，没有超时，为什么？不知道
   *
   * 2错：
   *
   * 一句话反思：再看看
   *
   * 新知识：
   */

  public boolean charMatchExceedTime(char sC, char pC) {
    return pC == '.' || sC == pC;
  }

  public boolean subMatchExceedTime(String s, String p, int sPos, int pPos) {
    if (pPos == p.length()) {
      return sPos == s.length();
    }
    char pChar = p.charAt(pPos);
    if (pPos < p.length() - 1 && p.charAt(pPos + 1) == '*') {
      if (subMatch(s, p, sPos, pPos + 2)) {
        return true;
      }
      for (int i = sPos; i < s.length(); i++) {
        if (charMatchExceedTime(s.charAt(i), pChar)) {
          if (subMatch(s, p, sPos + 1, pPos)) {
            return true;
          }
        } else {
          pPos += 2;
          sPos = i;
          break;
        }
      }
    } else {
      if (sPos == s.length()) {
        return false;
      }
      if (charMatchExceedTime(s.charAt(sPos), pChar)) {
        return subMatch(s, p, sPos + 1, pPos + 1);
      }
    }
    return false;
  }

  public boolean isMatchExceedTime(String s, String p) {
    if (p == null || p == "") {
      return s == null || s == "";
    }
    return subMatch(s, p, 0, 0);
  }


  public static void main(String[] args) {
    String s = "aaaaaaaaaaaaab";
    String p = "a*a*a*a*a*a*a*a*a*a*c";

    System.out.println(!isMatch(s, p));
  }
}

